package com.qztc.appdemo.controller;

import com.qztc.appdemo.config.DataResult;
import com.qztc.appdemo.model.Student;
import com.qztc.appdemo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.INTERNAL;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.ResultSet;

/**
 * @author wangxl
 * @ClassName StudentController
 * @Description
 * @date 2019/8/21 0:08
 */
@Api(tags = "学生接口")
@RestController
@RequestMapping("student")
public class StudentController {

  @Resource
  private StudentService studentService;

  @ApiOperation(value = "根据ID查询学生信息")
  @GetMapping("/selectByStudentId/{id}")
  public DataResult<Student> selectByStudentId(@RequestParam("id") Integer id){
    DataResult<Student> result = new DataResult<>();
    result.setBody(studentService.selectByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "根据ID删除学生信息")
  @GetMapping("/deleteByStudentId/{id}")
  public DataResult<Integer> deleteByStudentId(@RequestParam("id") Integer id){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(studentService.deleteByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "添加学生信息")
  @PostMapping("/insertStudent")
  public DataResult<Integer> insertStudent(@RequestBody Student student){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(studentService.insertSelective(student));
    return result;
  }

  @ApiOperation(value = "修改学生信息")
  @PostMapping("/updateStudent")
  public DataResult<Integer> updateStudent(@RequestBody Student student){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(studentService.updateByPrimaryKeySelective(student));
    return result;
  }



}
