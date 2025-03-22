package com.project.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 设备管理：(DeviceManagement)表实体类
 *
 */
@TableName("`device_management`")
@Data
@EqualsAndHashCode(callSuper = false)
public class DeviceManagement implements Serializable {

    // DeviceManagement编号
    @TableId(value = "device_management_id", type = IdType.AUTO)
    private Integer device_management_id;

    // 设备图
    @TableField(value = "`equipment_diagram`")
    private String equipment_diagram;
    // 设备编号
    @TableField(value = "`equipment_number`")
    private String equipment_number;
    // 设备名称
    @TableField(value = "`device_name`")
    private String device_name;
    // 设备分类
    @TableField(value = "`equipment_classification`")
    private String equipment_classification;
    // 库存数量
    @TableField(value = "`inventory_quantity`")
    private Integer inventory_quantity;
    // 详细介绍
    @TableField(value = "`detailed_introduction`")
    private String detailed_introduction;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
