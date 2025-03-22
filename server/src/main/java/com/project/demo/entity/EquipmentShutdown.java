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
 * 设备报停：(EquipmentShutdown)表实体类
 *
 */
@TableName("`equipment_shutdown`")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentShutdown implements Serializable {

    // EquipmentShutdown编号
    @TableId(value = "equipment_shutdown_id", type = IdType.AUTO)
    private Integer equipment_shutdown_id;

    // 设备编号
    @TableField(value = "`equipment_number`")
    private String equipment_number;
    // 设备名称
    @TableField(value = "`device_name`")
    private String device_name;
    // 设备分类
    @TableField(value = "`equipment_classification`")
    private String equipment_classification;
    // 报停日期
    @TableField(value = "`stop_reporting_date`")
    private Timestamp stop_reporting_date;
    // 报停原因
    @TableField(value = "`reason_for_reporting_suspension`")
    private String reason_for_reporting_suspension;
    // 维修说明
    @TableField(value = "`maintenance_instructions`")
    private String maintenance_instructions;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
