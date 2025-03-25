package com.unique.rule.check.service;

import com.unique.framework.common.http.exception.GlobalErrorCode;
import com.unique.framework.common.http.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date:2025/3/15 16:13
 * author: haohaounique@163.com
 */
@Component
public class StrategyService {


    // 新增一个 Map 用于存储 AbstractCheckService 实例，键为类的简单名称
    private final static Map<String, AbstractCheckService> CHECK_SERVICE_HASH_MAP = new HashMap<>();

    // 在构造函数中初始化 Map
    @Autowired
    public StrategyService(List<AbstractCheckService> checkServiceList) {
        for (AbstractCheckService service : checkServiceList) {
            CHECK_SERVICE_HASH_MAP.put(service.getClass().getSimpleName(), service);
        }
    }

    /**
     * 校验服务类
     *
     * @param clazzName
     * @return AbstractCheckService
     */
    public AbstractCheckService getCheckService(String clazzName) {
        // 提前对 clazzName 进行空值检查，避免空指针异常
        if (clazzName == null || clazzName.isEmpty()) {
            throw new GlobalException(GlobalErrorCode.FAIL, "传入的类名不能为空");
        }
        // 直接从 Map 中获取实例
        return CHECK_SERVICE_HASH_MAP.computeIfAbsent(clazzName, key -> {
            throw new GlobalException(GlobalErrorCode.FAIL, "未找到类名为 " + clazzName + " 的 AbstractCheckService 实例");
        });
    }
}
