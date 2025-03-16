-- 创建 rule_expression 表
CREATE TABLE rule_expression
(
    id              BIGINT NOT NULL PRIMARY KEY COMMENT '主键id',
    rule_key        VARCHAR(64) COMMENT '规则KEY,包含用户维护信息',
    class_key       VARCHAR(100) COMMENT '类名',
    class_name      varchar(64) COMMENT '类描述',
    expression      varchar(512) COMMENT '表达式',
    expression_name varchar(200) COMMENT '表达式描述',
    delete_flag     tinyint unsigned default 1 comment '0-失效 1-生效',
    create_time     datetime COMMENT '创建时间',
    create_user     VARCHAR(64) COMMENT '创建人',
    update_time     datetime COMMENT '更新时间',
    update_user     VARCHAR(64) COMMENT '更新建人'
) COMMENT '规则表达式';


CREATE TABLE rule_config
(
    id                BIGINT                     NOT NULL PRIMARY KEY COMMENT '主键id',
    rule_key          VARCHAR(255)               not null COMMENT '规则KEY',
    field_name        VARCHAR(255)               not null COMMENT '字段名称',
    field_description TEXT COMMENT '字段描述',
    class_name        VARCHAR(255)               not null COMMENT '类名',
    class_description TEXT COMMENT '类描述',
    expression        varchar(512)               not null COMMENT '表达式',
    rule_order        tinyint unsigned default 1 not null COMMENT '顺序0-字段基础校验 1-定制化校验',
    tip_code          VARCHAR(64)                not null COMMENT '提示信息',
    tip_message       varchar(512) COMMENT '提示信息',
    delete_flag       tinyint unsigned default 1 comment '0-失效 1-生效',
    create_time       datetime COMMENT '创建时间',
    create_user       VARCHAR(64) COMMENT '创建人',
    update_time       datetime COMMENT '更新时间',
    update_user       VARCHAR(64) COMMENT '更新人'
) COMMENT '规则配置';


CREATE TABLE rule_tip
(
    id          BIGINT NOT NULL PRIMARY KEY COMMENT '主键id',
    tip_code    VARCHAR(64) COMMENT '提示信息',
    tip_message varchar(512) COMMENT '提示信息',
    language    VARCHAR(64)      default 'cn' COMMENT '语言,默认',
    delete_flag tinyint unsigned default 1 comment '0-失效 1-生效',
    create_time datetime default now() COMMENT '创建时间',
    create_user VARCHAR(255) COMMENT '创建人',
    update_time datetime default now() COMMENT '更新时间',
    update_user VARCHAR(255) COMMENT '更新人'
) COMMENT '规则提示';