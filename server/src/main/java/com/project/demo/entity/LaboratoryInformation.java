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
 * 实验室信息：(LaboratoryInformation)表实体类
 *
 */
@TableName("`laboratory_information`")
@Data
@EqualsAndHashCode(callSuper = false)
public class LaboratoryInformation implements Serializable {

    // LaboratoryInformation编号
    @TableId(value = "laboratory_information_id", type = IdType.AUTO)
    private Integer laboratory_information_id;

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
    private Integer capacity;

    // 点击数
    @TableField(value = "hits")
    private Integer hits;

    // 点赞数
    @TableField(value = "praise_len")
    private Integer praise_len;








    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
