package com.unique.rule.check.service.impl.check.empty;

import cn.hutool.core.text.CharSequenceUtil;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 空字符串校验
 * date:2025/3/16 9:48
 * author: haohaounique@163.com
 */
@Service
public class BlankCheckService extends AbstractCheckService {
    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        String fieldValue = map.get(config.getFieldName());
        return CharSequenceUtil.isBlank(fieldValue);
    }
}
