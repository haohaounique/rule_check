package com.unique.rule.check.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * <p>
 * 规则提示
 * </p>
 *
 * @author haohaounique@163.com
 * @since 2025-03-15 16:39:05
 */
@Getter
@Setter
@ToString
@TableName("rule_tip")
public class RuleTip implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 提示信息
     */
    private String tipCode;

    /**
     * 提示信息
     */
    private String tipMessage;

    /**
     * 语言,默认
     */
    private String language;

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
