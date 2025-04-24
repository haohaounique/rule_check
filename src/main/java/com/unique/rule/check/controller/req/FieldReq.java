package com.unique.rule.check.controller.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * date:2025/3/13 23:01
 * author: haohaounique@163.com
 */
@Data
public class FieldReq {
    @Size(min = 1, message = "字段不能为空集合")
    private List<String> fieldList;
    @NotBlank(message = "value字段不能为空")
    private String value;
}
