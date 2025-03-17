package com.unique.rule.check.service.impl.check.transform;

import cn.hutool.core.collection.CollUtil;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * 转换处理
 * date:2025/3/17 21:22
 * author: haohaounique@163.com
 */
@Service
public class TransformCheckService extends AbstractCheckService {
    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        String fieldValue = map.get(config.getFieldName());
        if (Objects.isNull(fieldValue)) {
            return false;
        }
        String[] split = config.getExpression().split(";");
        if (CollUtil.size(split) < 1) {
            return false;
        }
        for (String s : split) {
            String[] kv = s.split(",");
            if (Objects.equals(kv[0], fieldValue)) {
                map.put(config.getFieldName(), kv[1]);
            }
        }

        return false;
    }
}
