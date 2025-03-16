package com.unique.rule.check.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unique.framework.common.http.exception.GlobalErrorCode;
import com.unique.framework.common.http.exception.GlobalException;
import com.unique.framework.common.http.http.PageQuery;
import com.unique.framework.common.http.http.PageResult;
import com.unique.framework.common.http.http.ReqBody;
import com.unique.rule.check.controller.req.RuleConfigAddReq;
import com.unique.rule.check.controller.req.RuleConfigPageSearchReq;
import com.unique.rule.check.controller.resp.RuleConfigResp;
import com.unique.rule.check.converter.RuleConfigConverter;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.mapper.RuleConfigMapper;
import com.unique.rule.check.service.AbstractCheckService;
import com.unique.rule.check.service.IRuleConfigService;
import com.unique.rule.check.service.StrategyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 规则配置 服务实现类
 * </p>
 *
 * @author haohaounique
 * @since 2025-03-15 16:37:01
 */
@Service
public class RuleConfigServiceImpl extends ServiceImpl<RuleConfigMapper, RuleConfig> implements IRuleConfigService {

    @Resource
    private StrategyService strategyService;

    @Override
    public PageResult<List<RuleConfigResp>> pageSearch(ReqBody<PageQuery<RuleConfigPageSearchReq>> reqBody) {

        return new PageResult<>();
    }

    @Override
    public boolean addRuleConfig(RuleConfigAddReq param) {
        RuleConfig ruleConfig = RuleConfigConverter.INSTANCE.toPo(param);
        ruleConfig.setId(IdWorker.getId());
        ruleConfig.setCreateTime(LocalDateTime.now());
        ruleConfig.setUpdateTime(LocalDateTime.now());
        ruleConfig.setCreateUser("system");
        ruleConfig.setUpdateUser("system");
        return this.save(ruleConfig);
    }

    @Override
    public Object checkParam(Map<String, String> param) {
        String ruleKey = param.get("rule_key");
        if (CharSequenceUtil.isBlank(ruleKey)) {
            throw new GlobalException(GlobalErrorCode.PARAMETER_EXCEPTION, "规则key不能为空");
        }
        LambdaQueryWrapper<RuleConfig> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RuleConfig::getRuleKey, ruleKey);
        queryWrapper.orderByAsc(RuleConfig::getRuleOrder);
        List<RuleConfig> list = this.list(queryWrapper);
        if (list.isEmpty()) {
            throw new GlobalException(GlobalErrorCode.PARAMETER_EXCEPTION, "未找到规则");
        }
        list.stream().parallel().forEach(ruleConfig -> {
            AbstractCheckService checkService = strategyService.getCheckService(ruleConfig.getClassName());
            boolean process = checkService.process(ruleConfig, param);
            if (process) {
                throw new GlobalException(GlobalErrorCode.PARAMETER_EXCEPTION, ruleConfig.getTipMessage());
            }
        });
        return true;
    }
}
