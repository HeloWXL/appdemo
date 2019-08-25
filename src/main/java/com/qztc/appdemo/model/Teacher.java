package com.qztc.appdemo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;
/**
 * 任课老师
 * @author xiayj
 * @since
 */
@Data
public class Teacher {
    @TableId(value = "teacher_id",type = IdType.AUTO)
    private Integer teacherId;

    private String teacherName;

    private String teacherTno;

    private String teacherPassword;

    private String teacherJobTitle;

    private String teacherSex;

    private Integer teacherAge;

    private Date createTime;

    private Integer professionId;

    @TableField(exist = false)
    private Profession profession;

}