package com.qztc.appdemo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * 课程
 * @author xiayj
 * @since
 */
public class Course {
    @TableId(value = "course_id",type = IdType.AUTO)
    private Integer courseId;

    private String courseName;

    private int teacherId;

    private Date ceateTime;

}