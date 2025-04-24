package com.unique.rule.check.controller.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * date:2025/3/16 9:33
 * author: haohaounique@163.com
 */
@Data
@Schema(description = "规则配置添加请求")
public class RuleConfigAddReq {
    /**
     * 规则KEY
     */
    @Schema(description = "规则KEY",requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "规则KEY不能为空")
    private String ruleKey;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    @NotBlank(message = "字段名称不能为空")
    private String fieldName;

    /**
     * 字段描述
     */
    @Schema(description = "字段描述")
    @NotBlank(message = "字段描述不能为空")
    private String fieldDescription;

    /**
     * 类名
     */
    @Schema(description = "类名")
    @NotBlank(message = "类名不能为空")
    private String className;

    /**
     * 类描述
     */
    @Schema(description = "类描述")
    @NotBlank(message = "类描述不能为空")
    private String classDescription;

    /**
     * 表达式
     */
    @Schema(description = "表达式")
    @NotBlank(message = "表达式不能为空")
    private String expression;

    /**
     * 顺序
     */
    @Schema(description = "顺序")
    @NotNull(message = "顺序不能为空")
    private Integer ruleOrder;

    /**
     * 提示信息
     */
    @Schema(description = "提示信息")
    @NotBlank(message = "提示信息编码不能为空")
    private String tipCode;

    /**
     * 提示信息
     */
    @Schema(description = "提示信息")
    @NotBlank(message = "提示信息不能为空")
    private String tipMessage;
}
