package com.unique.rule.check.converter;

import com.unique.rule.check.controller.req.RuleConfigAddReq;
import com.unique.rule.check.entity.RuleConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * date:2025/3/15 15:55
 * author: haohaounique@163.com
 */
@Mapper
public interface RuleConfigConverter {
    RuleConfigConverter INSTANCE = Mappers.getMapper(RuleConfigConverter.class);

    RuleConfig toPo(RuleConfigAddReq param);
}
