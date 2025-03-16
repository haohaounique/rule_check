package com.unique.rule.check.service;

import com.unique.framework.common.http.exception.GlobalErrorCode;
import com.unique.framework.common.http.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * date:2025/3/15 16:13
 * author: haohaounique@163.com
 */
@Component
public class StrategyService {


    @Autowired
    private List<AbstractCheckService> checkServiceList;

    /**
     * 校验服务类
     *
     * @param clazzName
     * @return AbstractCheckService
     */
    public AbstractCheckService getCheckService(String clazzName) {
        return checkServiceList.stream()
                .filter(item -> item.getClass().getSimpleName().equals(clazzName))
                .findFirst()
                .orElseThrow(() -> new GlobalException(GlobalErrorCode.FAIL,"未找到类名为 " + clazzName + " 的 AbstractCheckService 实例"));
    }

}
