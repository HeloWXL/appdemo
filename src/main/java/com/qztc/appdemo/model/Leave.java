package com.qztc.appdemo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
/**
 *
 * @author xiayj
 * @since
 */
@Data
@TableName(value = "leaves")
public class Leave {
    @TableId(value = "leave_id",type = IdType.AUTO)
    private Integer leaveId;

    private String studentSno;

    private String leaveTitle;

    private String leaveReason;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endTime;

    private Integer coundelorId;

    private Integer isRead;

    private Student student;
}