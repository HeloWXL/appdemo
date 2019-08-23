package com.qztc.appdemo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 * 学生
 * @author xiayj
 * @since
 */
@Data
public class Student {
    @TableId(value = "student_id",type = IdType.AUTO)
    private Integer studentId;

    private String studentName;

    private String studentSno;

    private String studentPassword;

    private String studentAge;

    private String studentQq;

    private String studentEmail;

    private String studentPic;

    private String studentSex;

    private Integer professionId;

    private Date createTime;

    private Profession profession;


}