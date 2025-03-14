package com.unique.rule.check.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * <p>
 * 规则配置
 * </p>
 *
 * @author haohaounique
 * @since 2025-03-14 23:08:08
 */
@Getter
@Setter
@ToString
@TableName("rule_config")
public class RuleConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 规则KEY
     */
    private String ruleKey;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段描述
     */
    private String fieldDescription;

    /**
     * 类名
     */
    private String className;

    /**
     * 类描述
     */
    private String classDescription;

    /**
     * 表达式
     */
    private String expression;

    /**
     * 顺序
     */
    private Integer ruleOrder;

    /**
     * 提示信息
     */
    private String tipCode;

    /**
     * 提示信息
     */
    private String tipMessage;

    /**
     * 0-失效 1-生效
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private String updateUser;
}
