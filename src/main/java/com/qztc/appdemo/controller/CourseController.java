package com.qztc.appdemo.controller;

import com.qztc.appdemo.config.DataResult;
import com.qztc.appdemo.model.Course;
import com.qztc.appdemo.model.Student;
import com.qztc.appdemo.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiayj
 * @ClassName CourseController
 * @Description
 * @date 2019/8/21 0:05
 */
@Api(tags = "课程接口")
@RestController
@RequestMapping("course")
public class CourseController {
  @Resource
  private CourseService courseService;

  @ApiOperation(value = "根据ID查询课程信息")
  @GetMapping("/selectByCourseId/{id}")
  public DataResult<Course> selectByCourseId(@RequestParam("id") Integer id){
    DataResult<Course> result = new DataResult<>();
    result.setBody(courseService.selectByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "根据ID删除课程信息")
  @GetMapping("/deleteByCourseId/{id}")
  public DataResult<Integer> deleteByCourseId(@RequestParam("id") Integer id){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(courseService.deleteByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "添加课程信息")
  @PostMapping("/insertStudent")
  public DataResult<Integer> insertStudent(@RequestBody Course course){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(courseService.insertSelective(course));
    return result;
  }

  @ApiOperation(value = "修改课程信息")
  @PostMapping("/updateCourse")
  public DataResult<Integer> updateCourse(@RequestBody Course course){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(courseService.updateByPrimaryKeySelective(course));
    return result;
  }
}
