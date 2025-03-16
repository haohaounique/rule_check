package com.unique.rule.check.service.impl.check.empty;

import cn.hutool.core.text.CharSequenceUtil;
import com.unique.rule.check.entity.RuleConfig;
import com.unique.rule.check.service.AbstractCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 非空校验
 * date:2025/3/13 22:57
 * author: haohaounique@163.com
 */
@Service
@Slf4j
public class EmptyCheckService extends AbstractCheckService {

    @Override
    public boolean process(RuleConfig config, Map<String, String> map) {
        String fieldValue = map.get(config.getFieldName());
        return CharSequenceUtil.isEmpty(fieldValue);
    }
}