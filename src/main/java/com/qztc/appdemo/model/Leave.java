package com.qztc.appdemo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;
/**
 *
 * @author xiayj
 * @since
 */
@Data
public class Leave {
    @TableId(value = "leave_id",type = IdType.AUTO)
    private Integer leaveId;

    private String studentSno;

    private String leaveReason;

    private Date startTime;

    private Date endTime;

    private Integer coundelorId;

    private Integer isRead;
}