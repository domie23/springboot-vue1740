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
 * 实验报告：(ExperimentalReport)表实体类
 *
 */
@TableName("`experimental_report`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ExperimentalReport implements Serializable {

    // ExperimentalReport编号
    @TableId(value = "experimental_report_id", type = IdType.AUTO)
    private Integer experimental_report_id;

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
    // 报告上传
    @TableField(value = "`report_upload`")
    private String report_upload;
    // 学生备注
    @TableField(value = "`student_notes`")
    private String student_notes;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
