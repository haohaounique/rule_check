package com.unique.rule.check.service.impl.check.length;

import com.unique.rule.check.common.util.DataCompareUtils;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * date:2025/3/16 9:55
 * author: haohaounique@163.com
 */
@Service
public class LengthCheckService extends AbstractCheckService {
    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        String fieldValue = map.get(config.getFieldName());
        return !DataCompareUtils.checkValue(String.valueOf(StringUtils.length(fieldValue)), config.getExpression());
    }
}
