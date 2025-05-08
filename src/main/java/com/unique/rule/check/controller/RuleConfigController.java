package com.unique.rule.check.controller;

import com.unique.framework.common.http.http.PageQuery;
import com.unique.framework.common.http.http.PageResult;
import com.unique.framework.common.http.http.ReqBody;
import com.unique.framework.common.http.http.RespBody;
import com.unique.rule.check.common.util.ValidateUtils;
import com.unique.rule.check.controller.req.FieldReq;
import com.unique.rule.check.controller.req.RuleConfigAddReq;
import com.unique.rule.check.controller.req.RuleConfigPageSearchReq;
import com.unique.rule.check.controller.resp.RuleConfigResp;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.IRuleConfigService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
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
        return new RespBody<>(ruleConfigService.pageSearch(reqBody));
    }

    /**
     * 新增规则配置
     */
    @PostMapping(value = "/add")
    public RespBody<Object> addRuleConfig(@RequestBody @Valid ReqBody<RuleConfigAddReq> reqBody) {
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

    @RequestMapping("/validate")
    public void validate() {
        FieldReq fieldReq = new FieldReq();
        ValidateUtils.validate(List.of(fieldReq));
    }

}
