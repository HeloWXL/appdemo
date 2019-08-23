package com.qztc.appdemo.model;

import java.util.Date;

public class Leave {
    private Integer leaveId;

    private Integer studentSno;

    private String leaveReason;

    private Date startTime;

    private Date endTime;

    private Integer coundelorId;

    private Integer isRead;

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getStudentSno() {
        return studentSno;
    }

    public void setStudentSno(Integer studentSno) {
        this.studentSno = studentSno;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason == null ? null : leaveReason.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCoundelorId() {
        return coundelorId;
    }

    public void setCoundelorId(Integer coundelorId) {
        this.coundelorId = coundelorId;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}