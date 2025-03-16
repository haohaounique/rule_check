package com.unique.rule.check.common.config;

import com.unique.framework.common.http.exception.GlobalErrorCode;
import com.unique.framework.common.http.exception.GlobalException;
import com.unique.framework.common.http.http.RespBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * date:2025/3/16 11:32
 * author: haohaounique@163.com
 */
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public RespBody<Object> handleThrowable(GlobalException ex) {
        RespBody<Object> resp = new RespBody<>(GlobalErrorCode.PARAMETER_EXCEPTION, ex.getMessage());
        resp.setCode(GlobalErrorCode.PARAMETER_EXCEPTION.getCode());
        resp.setResult(ex.getResult());
        return resp;
    }
}
