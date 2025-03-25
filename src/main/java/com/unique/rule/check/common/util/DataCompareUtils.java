package com.unique.rule.check.common.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * description: 数据比较工具类
 */
public class DataCompareUtils {
    private DataCompareUtils() {
    }
    private static final String SYMBOL_01 = "(,)";
    private static final String SYMBOL_02 = "[,)";
    private static final String SYMBOL_03 = "(,]";
    private static final String SYMBOL_04 = "[,]";
    private static final String SYMBOL_05 = "[,";
    private static final String SYMBOL_06 = "(,";
    private static final String SYMBOL_07 = ",]";
    private static final String SYMBOL_08 = ",)";

    private static final Map<String, String> SYMBOL_MAP = new HashMap<>();

    static {
        SYMBOL_MAP.put("(,)", "(,)");
        SYMBOL_MAP.put("[,)", "[,)");
        SYMBOL_MAP.put("(,]", "(,]");
        SYMBOL_MAP.put("[,]", "[,]");
        SYMBOL_MAP.put("[,", "[,");
        SYMBOL_MAP.put("(,", "(,");
        SYMBOL_MAP.put(",]", ",]");
        SYMBOL_MAP.put(",)", ",)");
    }



    private static final Pattern NUMBER_REG = Pattern.compile("^-?\\d+(\\.\\d+)?$");

    /**
     * 双边校验 返回true说明不符合
     * [4,5] (3,5)
     * 不符合返回false,符合区间返回true
     *
     * @param value
     * @return
     */

    public static boolean checkValue(String value, String config) {
        if (StringUtils.isEmpty(config)) {
            return false;
        }
        config = config.replace(" ", "").replace("，", ",").replace("（", "(").replace("【", "[").replace("】", "]").replace("）", ")").trim();
        config = config.replaceAll("[^0-9.()\\[\\],]", ""); //获取 [3,8]
        String s = config.replaceAll("[^\\[\\]\\(\\),]", "");//获取 []
        if (StringUtils.isEmpty(SYMBOL_MAP.get(s))) {
            return false;
        }
        /**
         * 第一个为值  第二个为配置表达式
         */

        boolean flag = false;
        switch (s) {
            case SYMBOL_01:
                flag = checkLeftNoAndRightNo(value, config);
                break;
            case SYMBOL_02:
                flag = checkLeftAndRightNo(value, config);
                break;
            case SYMBOL_03:
                flag = checkLeftNoAndRight(value, config);
                break;
            case SYMBOL_04:
                flag = checkLeftAndRight(value, config);
                break;
            case SYMBOL_05:
                flag = checkLeft(value, config);
                break;
            case SYMBOL_06:
                flag = checkLeftNo(value, config);
                break;
            case SYMBOL_07:
                flag = checkRight(value, config);
                break;
            case SYMBOL_08:
                flag = checkRightNo(value, config);
                break;
            default:
                break;
        }
        return flag;
    }

    //(5,8)
    private static boolean checkLeftNoAndRightNo(String value, String config) {
        String range = config.replace("(", "").replace(")", "");
        String[] split = range.split(",");
        return checkNoIncludeMin(value, split[0]) && checkNoIncludeMax(value, split[1]);
    }

    //(5,8]
    private static boolean checkLeftNoAndRight(String value, String config) {
        String range = config.replace("(", "").replace("]", "");
        String[] split = range.split(",");
        return checkNoIncludeMin(value, split[0]) && checkIncludeMax(value, split[1]);
    }

    //[5,8)
    private static boolean checkLeftAndRightNo(String value, String config) {
        String range = config.replace("[", "").replace(")", "");
        String[] split = range.split(",");
        return checkIncludeMin(value, split[0]) && checkNoIncludeMax(value, split[1]);
    }

    //[5,8]
    private static boolean checkLeftAndRight(String value, String config) {
        String range = config.replace("[", "").replace("]", "");
        String[] split = range.split(",");
        return checkIncludeMin(value, split[0]) && checkIncludeMax(value, split[1]);
    }

    //(5,
    private static boolean checkLeftNo(String value, String config) {
        String range = config.replace("(", "").replace(",", "");
        return checkNoIncludeMin(value, range);
    }

    //[5,
    private static boolean checkLeft(String value, String config) {
        String range = config.replace("[", "").replace(",", "");
        return checkIncludeMin(value, range);
    }

    //,8)
    private static boolean checkRightNo(String value, String config) {
        String range = config.replace(")", "").replace(",", "");
        return checkNoIncludeMax(value, range);
    }

    //,8]
    private static boolean checkRight(String value, String config) {
        String range = config.replace("]", "").replace(",", "");
        return checkIncludeMax(value, range);
    }


    /**
     * 校验下限 不含 （6,
     *
     * @param value
     * @param target
     * @return
     */
    private static boolean checkNoIncludeMin(String value, String target) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(target)) {
            return false;
        }
        if (BigDecimal.valueOf(Double.parseDouble(value)).compareTo(BigDecimal.valueOf(Double.parseDouble(target))) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 含最小 [6,
     *
     * @param value
     * @param target
     * @return
     */
    private static boolean checkIncludeMin(String value, String target) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(target)) {
            return false;
        }
        if (BigDecimal.valueOf(Double.parseDouble(value)).compareTo(BigDecimal.valueOf(Double.parseDouble(target))) >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 最大包含  ,6]
     *
     * @param value
     * @param target
     * @return
     */
    private static boolean checkIncludeMax(String value, String target) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(target)) {
            return false;
        }
        if (BigDecimal.valueOf(Double.parseDouble(value)).compareTo(BigDecimal.valueOf(Double.parseDouble(target))) <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 不含最大校验    ,6)
     *
     * @param value
     * @param target
     * @return
     */
    private static boolean checkNoIncludeMax(String value, String target) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(target)) {
            return false;
        }
        if (BigDecimal.valueOf(Double.parseDouble(value)).compareTo(BigDecimal.valueOf(Double.parseDouble(target))) < 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为数字
     *
     * @param value
     * @return
     */
    public static boolean checkIsNumber(String value) {
        return NUMBER_REG.matcher(value).matches();
    }

    //\u00A0,\u0020,\u3000
//    1.不间断空格\u00A0,主要用在office中,让一个单词在结尾处不会换行显示,快捷键ctrl+shift+space ;
//2.半角空格(英文符号)\u0020,代码中常用的;
//3.全角空格(中文符号)\u3000,中文文章中使用;
    public static String replaceSpecialEmpty(String value) {
        if (StringUtils.isEmpty(value)) {
            return value;
        }
        return value.replace("\\u00A0", "").replace("\\u0020", "").replace("\\u3000", "");
    }


    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("(5,8)");
        arrayList.add("[5,8)");
        arrayList.add("(5,8]");
        arrayList.add("[5,8]");
        arrayList.add("[5,");
        arrayList.add("(5,");
        arrayList.add(",8]");
        arrayList.add(",8)");
        String target = "8.0";
        for (String s : arrayList) {
            boolean checked = checkValue(target, s);
            System.out.printf("s:%s ,%s, %s", s, target, checked);
            System.out.println();
        }

    }

}
