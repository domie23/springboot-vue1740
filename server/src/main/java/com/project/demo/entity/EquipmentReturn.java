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
 * 设备归还：(EquipmentReturn)表实体类
 *
 */
@TableName("`equipment_return`")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentReturn implements Serializable {

    // EquipmentReturn编号
    @TableId(value = "equipment_return_id", type = IdType.AUTO)
    private Integer equipment_return_id;

    // 设备编号
    @TableField(value = "`equipment_number`")
    private String equipment_number;
    // 设备名称
    @TableField(value = "`device_name`")
    private String device_name;
    // 设备分类
    @TableField(value = "`equipment_classification`")
    private String equipment_classification;
    // 借用教师
    @TableField(value = "`borrowing_teachers`")
    private Integer borrowing_teachers;
    // 归还数量
    @TableField(value = "`return_quantity`")
    private Integer return_quantity;
    // 联系方式
    @TableField(value = "`contact_information`")
    private String contact_information;
    // 归还日期
    @TableField(value = "`return_date`")
    private Timestamp return_date;
    // 备注
    @TableField(value = "`remarks`")
    private String remarks;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
