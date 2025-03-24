package com.unique.rule.check.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.unique.framework.common.http.http.PageQuery;
import com.unique.framework.common.http.http.PageResult;
import com.unique.framework.common.http.http.ReqBody;
import com.unique.framework.common.http.http.RespBody;
import com.unique.rule.check.controller.req.RuleConfigAddReq;
import com.unique.rule.check.controller.req.RuleConfigPageSearchReq;
import com.unique.rule.check.controller.resp.RuleConfigResp;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.IRuleConfigService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 规则配置 前端控制器
 * </p>
 *
 * @author haohaounique@163.com
 * @since 2025-03-14 22:48:24
 */
@RestController
@RequestMapping("/ruleConfig")
public class RuleConfigController {

    @Resource
    private IRuleConfigService ruleConfigService;


    @PostMapping(value = "/pageSearch")
    public RespBody<Object> pageSearch(@RequestBody ReqBody<PageQuery<RuleConfigPageSearchReq>> reqBody) {
        PageResult<List<RuleConfigResp>> pageResult = ruleConfigService.pageSearch(reqBody);
        return new RespBody<>(pageResult);
    }

    /**
     * 新增规则配置
     */
    @PostMapping(value = "/add")
    public RespBody<Object> addRuleConfig(@RequestBody ReqBody<RuleConfigAddReq> reqBody) {
        return new RespBody<>(ruleConfigService.addRuleConfig(reqBody.getParam()));
    }

    /**
     * 删除规则配置
     */
    @DeleteMapping("/{id}")
    public RespBody<Object> deleteRuleConfig(@PathVariable Long id) {
        boolean result = ruleConfigService.removeById(id);
        return new RespBody<>(result);
    }

    /**
     * 修改规则配置
     */
    @PutMapping(value = "/update")
    public RespBody<Object> updateRuleConfig(@RequestBody ReqBody<RuleConfig> reqBody) {
        boolean result = ruleConfigService.updateById(reqBody.getParam());
        return new RespBody<>(result);
    }

}
