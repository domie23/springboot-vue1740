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
 * 预约时段：(AppointmentPeriod)表实体类
 *
 */
@TableName("`appointment_period`")
@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentPeriod implements Serializable {

    // AppointmentPeriod编号
    @TableId(value = "appointment_period_id", type = IdType.AUTO)
    private Integer appointment_period_id;

    // 预约时段
    @TableField(value = "`time_interval`")
    private String time_interval;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
