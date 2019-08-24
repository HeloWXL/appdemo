package com.qztc.appdemo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author wangxl
 * @ClassName TeacherVo
 * @Description TODO
 * @date 2019/8/24 16:47
 * @Version 1.0
 */
@Data
public class TeacherVo {

  private Integer teacherId;

  private String teacherName;

  private String teacherTno;

  private String teacherPassword;

  private String teacherJobTitle;

  private String teacherSex;

  private Integer teacherAge;

  private Date createTime;

  private Integer professionId;

  private String professionName;

  private String apartment;

  private String school;

}
