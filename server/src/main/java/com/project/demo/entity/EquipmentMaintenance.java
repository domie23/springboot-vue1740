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
 * 设备维修：(EquipmentMaintenance)表实体类
 *
 */
@TableName("`equipment_maintenance`")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentMaintenance implements Serializable {

    // EquipmentMaintenance编号
    @TableId(value = "equipment_maintenance_id", type = IdType.AUTO)
    private Integer equipment_maintenance_id;

    // 设备编号
    @TableField(value = "`equipment_number`")
    private String equipment_number;
    // 设备名称
    @TableField(value = "`device_name`")
    private String device_name;
    // 设备分类
    @TableField(value = "`equipment_classification`")
    private String equipment_classification;
    // 维修日期
    @TableField(value = "`repair_date`")
    private Timestamp repair_date;
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
