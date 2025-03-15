package com.unique.rule.check.controller;

import com.unique.framework.common.http.http.PageQuery;
import com.unique.framework.common.http.http.PageResult;
import com.unique.framework.common.http.http.ReqBody;
import com.unique.framework.common.http.http.RespBody;
import com.unique.rule.check.controller.req.RuleConfigPageSearchReq;
import com.unique.rule.check.controller.resp.RuleConfigResp;
import com.unique.rule.check.service.IRuleConfigService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 规则配置 前端控制器
 * </p>
 *
 * @author haohaounique
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

}
