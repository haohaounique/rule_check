package com.unique.rule.check.controller;

import com.unique.framework.common.http.http.ReqBody;
import com.unique.framework.common.http.http.RespBody;
import com.unique.rule.check.service.IRuleConfigService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * date:2025/3/13 23:02
 * author: haohaounique@163.com
 */
@RestController
@RequestMapping("/check")
public class CheckController {


    @Resource
    private IRuleConfigService ruleConfigService;


    @RequestMapping("/process")
    public RespBody<Object> process(@RequestBody ReqBody<Map<String, String>> reqBody) {
        return new RespBody<>(ruleConfigService.checkParam(reqBody.getParam()), reqBody.getHooks());
    }

}
