package com.unique.rule.check.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * <p>
 * 规则表达式
 * </p>
 *
 * @author haohaounique
 * @since 2025-03-15 16:39:04
 */
@Getter
@Setter
@ToString
@TableName("rule_expression")
public class RuleExpression implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 规则KEY,包含用户维护信息
     */
    private String ruleKey;

    /**
     * 类名
     */
    private String classKey;

    /**
     * 类描述
     */
    private String className;

    /**
     * 表达式
     */
    private String expression;

    /**
     * 表达式描述
     */
    private String expressionName;

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
     * 更新建人
     */
    private String updateUser;
}
