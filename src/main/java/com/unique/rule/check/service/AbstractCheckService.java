package com.unique.rule.check.service;

import com.unique.rule.check.entity.RuleConfig;

import java.util.Map;

/**
 * 抽象规则校验服务
 * date:2025/3/13 22:57
 * author: haohaounique@163.com
 */
public abstract class AbstractCheckService {
    /**
     *
     * @return 验证结果
     */
    public abstract boolean process(RuleConfig config, Map<String, String> map);


}
