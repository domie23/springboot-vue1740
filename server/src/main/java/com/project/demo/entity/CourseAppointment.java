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
 * 课程预约：(CourseAppointment)表实体类
 *
 */
@TableName("`course_appointment`")
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseAppointment implements Serializable {

    // CourseAppointment编号
    @TableId(value = "course_appointment_id", type = IdType.AUTO)
    private Integer course_appointment_id;

    // 实验室名
    @TableField(value = "`laboratory_name`")
    private String laboratory_name;
    // 实验室编号
    @TableField(value = "`laboratory_number`")
    private String laboratory_number;
    // 位置
    @TableField(value = "`position`")
    private String position;
    // 课程名称
    @TableField(value = "`course_name`")
    private String course_name;
    // 课程类别
    @TableField(value = "`course_category`")
    private String course_category;
    // 任课老师
    @TableField(value = "`lecturer`")
    private Integer lecturer;
    // 上课时间
    @TableField(value = "`class_time`")
    private String class_time;
    // 预约时段
    @TableField(value = "`appointment_period`")
    private String appointment_period;
    // 预约数
    @TableField(value = "`number_of_appointments`")
    private String number_of_appointments;
    // 学生姓名
    @TableField(value = "`student_name`")
    private Integer student_name;



    // 审核状态
    @TableField(value = "examine_state")
    private String examine_state;



    // 审核回复
    @TableField(value = "examine_reply")
    private String examine_reply;




    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
