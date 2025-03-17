package com.unique.rule.check.common.util;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * description: 正则表达式
 */
public class RegUtils {
    private RegUtils(){}

    public static Cache<String, Pattern> REG_PATTERN_CACHE = Caffeine.newBuilder().maximumSize(1000).expireAfterWrite(10, TimeUnit.SECONDS).build();

    /**
     * 获取提前编译的正则表达式
     * @param regex
     * @return
     */
    public static Pattern getRegPattern(String regex){
        if (StringUtils.isEmpty(regex)) {
            throw new IllegalArgumentException("正则表达式参数不能为空");
        }
        Pattern ifPresent = REG_PATTERN_CACHE.getIfPresent(regex);
        if (Objects.nonNull(ifPresent)) {
            return ifPresent;
        }
        Pattern compile = Pattern.compile(regex);
        REG_PATTERN_CACHE.put(regex, compile);
        return compile;
    }


    public static void main(String[] args) {
        List<String> regList = new ArrayList<>();
        regList.add("[0-9]{5}[-]{1}[0-9]{3}");
        for (String s : regList) {
            StopWatch stopWatch = new StopWatch("测试");
            stopWatch.start();
            Pattern regPattern = getRegPattern(s);
            regPattern.matcher("99999-777");
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
        StopWatch stopWatch = new StopWatch("测试2");
        stopWatch.start();
        Pattern regPattern = getRegPattern(regList.get(0));
        regPattern.matcher("99999-777");
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }



}