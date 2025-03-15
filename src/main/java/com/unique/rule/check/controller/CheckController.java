package com.unique.rule.check.controller;

import com.unique.framework.common.http.http.ReqBody;
import com.unique.framework.common.http.http.RespBody;
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

    @RequestMapping("/process")
    public RespBody<Object> process(@RequestBody ReqBody<Map<String, String>> reqBody) {
        String appName = reqBody.getAppName();
        Map<String, String> param = reqBody.getParam();
        String ruleKey = param.get("rule_key");
        return new RespBody<>();
    }
}
