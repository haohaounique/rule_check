package com.unique.rule.check.service.impl.check.empty;

import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * date:2025/3/16 9:50
 * author: haohaounique@163.com
 */
@Service
public class CustomEmptyCheckService extends AbstractCheckService {
    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        // 若字段值为空，直接返回 true
        String fieldValue = map.get(config.getFieldName());
        if (Objects.isNull(fieldValue)) {
            return true;
        }
        // 使用 Stream API 检查字段值是否匹配表达式中的任意一个单词
        return Arrays.asList(config.getExpression().split(",")).contains(fieldValue);
    }
}
