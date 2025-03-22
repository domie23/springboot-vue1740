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
 * 实验成绩：(ExperimentalResults)表实体类
 *
 */
@TableName("`experimental_results`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ExperimentalResults implements Serializable {

    // ExperimentalResults编号
    @TableId(value = "experimental_results_id", type = IdType.AUTO)
    private Integer experimental_results_id;

    // 实验室名
    @TableField(value = "`laboratory_name`")
    private String laboratory_name;
    // 实验室编号
    @TableField(value = "`laboratory_number`")
    private String laboratory_number;
    // 课程名称
    @TableField(value = "`course_name`")
    private String course_name;
    // 课程类别
    @TableField(value = "`course_category`")
    private String course_category;
    // 任课老师
    @TableField(value = "`lecturer`")
    private Integer lecturer;
    // 学生姓名
    @TableField(value = "`student_name`")
    private Integer student_name;
    // 实验成绩
    @TableField(value = "`experimental_results`")
    private Integer experimental_results;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
