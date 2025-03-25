package com.unique.rule.check.service.impl.check.compare;

import com.unique.rule.check.common.util.DataCompareUtils;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * date:2025/3/25 20:28
 * author: haohaounique@163.com
 * (5,8) 8  false
 * [5,8) 8  false
 * (5,8] 8  true
 * [5,8] 8  true
 * [5,   8 true
 * (5,   8 true
 * ,8]   8  true
 * ,8)   8  false
 */
@Service
public class CompareCheckService extends AbstractCheckService {
    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        String fieldValue = map.get(config.getFieldName());
        return !DataCompareUtils.checkValue(fieldValue, config.getExpression());
    }
}
