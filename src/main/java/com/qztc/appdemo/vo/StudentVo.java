package com.qztc.appdemo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author wangxl
 * @ClassName StudentVo
 * @Description TODO
 * @date 2019/8/24 16:46
 * @Version 1.0
 */
@Data
public class StudentVo {

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

//专业属性

  private String professionName;

  private String apartment;

  private String school;




}
