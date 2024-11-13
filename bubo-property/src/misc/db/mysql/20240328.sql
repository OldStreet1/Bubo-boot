-- ----------------------------
-- 1、资产管理
-- ----------------------------

CREATE TABLE `property_type`
(
    `ID`             int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `OBJ_ID`         varchar(32) DEFAULT NULL COMMENT '主键',
    `PID`            varchar(32) DEFAULT NULL COMMENT '父主键ID',
    `TYPE_NAME`      varchar(50) DEFAULT NULL COMMENT '类型名称',
    `TYPE_CODE`      varchar(50) DEFAULT NULL COMMENT '类型编码',
    `GEOGRAPHY_TYPE` char(20)    DEFAULT NULL COMMENT '地理类型：标点 mark   区域 grid  线路  line ',
    `STROKE_COLOUR`  varchar(50) DEFAULT NULL COMMENT '线的颜色',
    `STROKE_WEIGHT`  varchar(50) DEFAULT NULL COMMENT '线的宽度',
    `FILL_COLOUR`    varchar(50) DEFAULT NULL COMMENT '填充颜色',
    `MAP_ICON`       varchar(50) DEFAULT NULL COMMENT '地图图标',
    `EXTEND_CONF`     text COMMENT '扩展字段,JSON格式',
    `DELETE_FLAG`    char(1)     DEFAULT NULL COMMENT '删除标识',
    `CREATE_TIME`    datetime     COMMENT '创建时间',
    `UPDATE_TIME`    datetime     COMMENT '修改时间',
    `CREATE_USER`    varchar(32) DEFAULT NULL COMMENT '创建人',
    PRIMARY KEY (`ID`)
) COMMENT='资产管理类型';


CREATE TABLE `property_info`
(
    `ID`                 int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `OBJ_ID`             varchar(32)  DEFAULT NULL COMMENT '主键',
    `COMPONENT_TYPE_ID`  varchar(32)  DEFAULT NULL COMMENT '部件类型ID',
    `COMPONENT_CODE`     varchar(50)  DEFAULT NULL COMMENT '部件编码',
    `COMPONENT_NAME`     varchar(200) DEFAULT NULL COMMENT '部件名称',
    `ADMIN_ORG`          varchar(32)  DEFAULT NULL COMMENT '管理单位',
    `GEOGRAPHY_LOCATION` text COMMENT '地理坐标',
    `ENABLE_STATUS`      char(1)      DEFAULT NULL COMMENT '启用状态 1 启用 2 禁用',
    `ADDRESS`            varchar(500) DEFAULT NULL COMMENT '地址',
    `REMARK`             varchar(500) DEFAULT NULL COMMENT '备注',
    `EXTEND`             text COMMENT '扩展字段,JSON格式',
    `DORG_ID`            varchar(32)  DEFAULT NULL COMMENT '独管单位ID',
    `DELETE_FLAG`        char(1)      DEFAULT NULL COMMENT '删除标识',
    `CREATE_TIME`        datetime      COMMENT '创建时间',
    `UPDATE_TIME`        datetime      COMMENT '修改时间',
    `CREATE_USER`        varchar(32)  DEFAULT NULL COMMENT '创建人',
    PRIMARY KEY (`ID`)
)COMMENT='资产管理信息';