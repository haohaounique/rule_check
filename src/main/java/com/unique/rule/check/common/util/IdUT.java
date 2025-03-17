package com.unique.rule.check.common.util;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * date:2025/3/16 11:13
 * author: haohaounique@163.com
 */
public class IdUT {

    private static String tips = "你好";
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(IdWorker.getId());
        }
        String format = String.format(tips, "1");
        System.out.println(format);

    }
}
