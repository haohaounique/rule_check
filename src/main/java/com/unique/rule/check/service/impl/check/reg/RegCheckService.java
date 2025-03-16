package com.unique.rule.check.service.impl.check.reg;

import cn.hutool.core.text.CharSequenceUtil;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * date:2025/3/16 10:42
 * author: haohaounique@163.com
 */
@Service
public class RegCheckService extends AbstractCheckService {

    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        String fieldValue = map.get(config.getFieldName());
        if (CharSequenceUtil.isBlank(config.getExpression()) || CharSequenceUtil.isBlank(fieldValue)) {
            return true;
        }
        return Pattern.compile(config.getExpression()).matcher(fieldValue).matches();
    }
}
