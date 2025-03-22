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
 * 实验课程：(ExperimentalCourses)表实体类
 *
 */
@TableName("`experimental_courses`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ExperimentalCourses implements Serializable {

    // ExperimentalCourses编号
    @TableId(value = "experimental_courses_id", type = IdType.AUTO)
    private Integer experimental_courses_id;

    // 实验室图
    @TableField(value = "`laboratory_diagram`")
    private String laboratory_diagram;
    // 实验室编号
    @TableField(value = "`laboratory_number`")
    private String laboratory_number;
    // 实验室名
    @TableField(value = "`laboratory_name`")
    private String laboratory_name;
    // 位置
    @TableField(value = "`position`")
    private String position;
    // 容纳人数
    @TableField(value = "`capacity`")
    private String capacity;
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
    // 课程简介
    @TableField(value = "`course_introduction`")
    private String course_introduction;
    // 设施情况
    @TableField(value = "`facilities`")
    private String facilities;

    // 点击数
    @TableField(value = "hits")
    private Integer hits;









    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
