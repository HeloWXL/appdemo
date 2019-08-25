package com.qztc.appdemo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 * 课程
 * @author xiayj
 * @since
 */
@Data
@TableName(value = "course")
public class Course {
    @TableId(value = "course_id",type = IdType.AUTO)
    private Integer courseId;

    @TableField("coundelor_name")
    private String courseName;

    @TableField("teacher_id")
    private int teacherId;

    @TableField("create_time")
    private Date ceateTime;

    private Teacher teacher;

}