package com.unique.rule.check.service.impl.check.contains;

import com.unique.rule.check.common.util.RegUtils;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * date:2025/3/17 21:26
 * author: haohaounique@163.com
 */
@Service
public class RegOrCheckService extends AbstractCheckService {
    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        String fieldValue = map.get(config.getFieldName());
        String[] split = config.getExpression().split("[||]");
        boolean flag = false;
        for (String s : split) {
            boolean matches = RegUtils.getRegPattern(s).matcher(fieldValue).matches();
            flag = flag || matches;
        }
        return !flag;
    }
}
