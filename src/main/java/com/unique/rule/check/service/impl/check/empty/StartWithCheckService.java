package com.unique.rule.check.service.impl.check.empty;

import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

/**
 * date:2025/3/16 10:46
 * author: haohaounique@163.com
 */
@Service
public class StartWithCheckService extends AbstractCheckService {
    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        String fieldValue = map.get(config.getFieldName());
        return Arrays.stream(config.getExpression().split(",")).parallel().anyMatch(fieldValue::startsWith);
    }

}
