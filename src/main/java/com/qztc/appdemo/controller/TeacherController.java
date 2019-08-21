package com.qztc.appdemo.controller;

import com.qztc.appdemo.config.DataResult;
import com.qztc.appdemo.model.Student;
import com.qztc.appdemo.model.Teacher;
import com.qztc.appdemo.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @ClassName TeacherController
 * @Description
 * @date 2019/8/21 0:08
 */
@Api(tags = "教师接口")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
  @Resource
  private TeacherService teacherService;

  @ApiOperation(value = "根据ID查询教师信息")
  @GetMapping("/selectByTeacherId/{id}")
  public DataResult<Teacher> selectByTeacherId(@RequestParam("id") Integer id){
    DataResult<Teacher> result = new DataResult<>();
    result.setBody(teacherService.selectByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "根据ID删除教师信息")
  @GetMapping("/deleteByTeacherId/{id}")
  public DataResult<Integer> deleteByTeacherId(@RequestParam("id") Integer id){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(teacherService.deleteByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "添加教师信息")
  @PostMapping("/insertTeacher")
  public DataResult<Integer> insertTeacher(@RequestBody Teacher teacher){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(teacherService.insertSelective(teacher));
    return result;
  }

  @ApiOperation(value = "修改教师信息")
  @PostMapping("/updateStudent")
  public DataResult<Integer> updateStudent(@RequestBody Teacher teacher){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(teacherService.updateByPrimaryKeySelective(teacher));
    return result;
  }


}
