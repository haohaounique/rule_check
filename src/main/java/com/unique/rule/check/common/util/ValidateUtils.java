package com.unique.rule.check.common.util;

import jakarta.annotation.Resource;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * date:2025/4/23 22:56
 * author: haohaounique@163.com
 */
@Component
public class ValidateUtils {

    public static final String TIP = "第%s行数据异常,%s,请检查";
    //注意jdk版本不同引入的包不同
    //import jakarta.validation.Validator;
    //import javax.validation.Validator;
    private static Validator validator;

    public Validator getValidator() {
        return validator;
    }

    @Resource
    public void setValidator(Validator validator) {
        ValidateUtils.validator = validator;
    }


    //默认从第1行开始 index=1
    public static <T> void validate(List<T> list) {
        if (Objects.isNull(list) || list.isEmpty()) {
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (T t : list) {
            int lineNo = atomicInteger.addAndGet(1);
            Set<ConstraintViolation<T>> validate = validator.validate(t);
            if (!validate.isEmpty()) {
                //可自定义
                throw new IllegalArgumentException(String.format(TIP,lineNo,validate.iterator().next().getMessage()));
            }
        }
    }
    //指定起始行号
    public static <T> void validate(List<T> list,Integer startIndex) {
        if (Objects.isNull(list) || list.isEmpty()) {
            return;
        }
        if (startIndex==null || startIndex<0) {
            startIndex = 0;
        }
        AtomicInteger atomicInteger = new AtomicInteger(startIndex);
        for (T t : list) {
            int lineNo = atomicInteger.addAndGet(1);
            Set<ConstraintViolation<T>> validate = validator.validate(t);
            if (!validate.isEmpty()) {
                //可自定义
                throw new IllegalArgumentException(String.format(TIP,lineNo,validate.iterator().next().getMessage()));
            }
        }
    }
}
