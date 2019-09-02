package com.qztc.appdemo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 *
 * @author
 * @since
 */
@Data
public class Course {
    @TableId(value = "course_id",type = IdType.AUTO)
    private Integer courseId;

    @TableField("course_name")
    private String courseName;

    @TableField("classarrangement")
    private Integer classarrangement;

    @TableField("startTime")
    private Date starttime;

    @TableField("ednTime")
    private Date endtime;

    @TableField("profession")
    private Integer profession;

    @TableField("teacher_id")
    private Integer teacherId;

    @TableField("crete_time")
    private Date ceateTime;
}