package com.unique.rule.check.service.impl;

import com.unique.framework.common.http.http.PageQuery;
import com.unique.framework.common.http.http.PageResult;
import com.unique.framework.common.http.http.ReqBody;
import com.unique.rule.check.controller.req.RuleConfigPageSearchReq;
import com.unique.rule.check.controller.resp.RuleConfigResp;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.mapper.RuleConfigMapper;
import com.unique.rule.check.service.IRuleConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public PageResult<List<RuleConfigResp>> pageSearch(ReqBody<PageQuery<RuleConfigPageSearchReq>> reqBody) {

        return new PageResult<>();
    }

}
