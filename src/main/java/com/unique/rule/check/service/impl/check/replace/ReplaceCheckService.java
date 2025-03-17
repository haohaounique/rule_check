package com.unique.rule.check.service.impl.check.replace;

import cn.hutool.core.text.CharSequenceUtil;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * date:2025/3/17 21:17
 * author: haohaounique@163.com
 */
@Service
@Slf4j
public class ReplaceCheckService extends AbstractCheckService {
    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        String fieldValue = map.get(config.getFieldName());
        if (CharSequenceUtil.isBlank(fieldValue)) {
            return false;
        }
        String[] splitAll = config.getExpression().split(";");
        for (String s : splitAll) {
            String[] split = s.split(",");
            fieldValue = fieldValue.replace(split[0], split[1]);
        }
        log.info("替换前后的字段值:【{},{}】", map.get(config.getFieldName()), fieldValue);
        map.put(config.getFieldName(), fieldValue);
        return false;
    }
}
