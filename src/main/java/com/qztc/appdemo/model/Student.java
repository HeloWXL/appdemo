package com.qztc.appdemo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 * 学生
 * @author xiayj
 * @since
 */
@Data
@TableName(value = "student")
public class Student {
    @TableId(value = "student_id",type = IdType.AUTO)
    private Integer studentId;

    @TableField("student_name")
    private String studentName;

    @TableField("student_sno")
    private String studentSno;

    @TableField("student_password")
    private String studentPassword;

    @TableField("student_age")
    private String studentAge;

    @TableField("student_qq")
    private String studentQq;

    @TableField("student_email")
    private String studentEmail;

    @TableField("student_pic")
    private String studentPic;

    @TableField("student_sex")
    private String studentSex;

    @TableField("profession_id")
    private Integer professionId;

    @TableField("create_time")
    private Date createTime;

    @TableField(exist = false)
    private Profession profession;


}