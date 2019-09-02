package com.qztc.appdemo.controller;

import com.qztc.appdemo.config.DataResult;
import com.qztc.appdemo.model.Course;
import com.qztc.appdemo.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author xiayj
 * @ClassName CourseController
 * @Description
 * @date 2019/8/21 0:05
 */
@Api(tags = "课程接口")
@Controller
@RequestMapping("courseApi")
public class CourseController {
  @Resource
  private CourseService courseService;

  @ApiOperation(value = "根据ID查询课程信息")
  @GetMapping("/selectByCourseId/{id}")
  @ResponseBody
  public DataResult<Course> selectByCourseId(@RequestParam("id") Integer id){
    DataResult<Course> result = new DataResult<>();
    result.setBody(courseService.selectByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "根据ID删除课程信息")
  @GetMapping("/deleteByCourseId/{id}")
  @ResponseBody
  public DataResult<Integer> deleteByCourseId(@PathVariable("id") Integer id){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(courseService.deleteByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "添加课程信息")
  @PostMapping("/insertCourse")
  @ResponseBody
  public DataResult<Integer> insertStudent(@RequestBody Course course){
    DataResult<Integer> result = new DataResult<>();



    result.setBody(courseService.insertSelective(course));
    return result;
  }

  @ApiOperation(value = "修改课程信息")
  @PostMapping("/updateCourse")
  @ResponseBody
  public DataResult<Integer> updateCourse(@RequestBody Course course){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(courseService.updateByPrimaryKeySelective(course));
    return result;
  }

  @ApiOperation(value = "查询课程信息")
  @GetMapping("/selectCourseByPage")
  @ResponseBody
  public DataResult<Map<String,Object>> selectCourseByPage(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSieze") Integer pageSieze){
    DataResult<Map<String,Object>> result = new DataResult<>();
    result.setBody(courseService.getCourseByPage(pageNo,pageSieze));
    return result;
  }

  @ApiOperation(value = "查询课程信息")
  @GetMapping("/selectCourseListByTno")
  @ResponseBody
  public DataResult<Map<String,Object>> selectCourseListByTno(@RequestParam("pageNo") Integer pageNo,
                                                              @RequestParam("pageSize") Integer pageSize,
                                                              @RequestParam("tid") Integer tid){
    DataResult<Map<String,Object>> result = new DataResult<>();
    result.setBody(courseService.selectCourseByTno(pageNo,pageSize,tid));
    return result;
  }

  @ApiOperation(value = "根据ID查询课程的详细信息")
  @GetMapping("/selectCourseDetailByCid/{cid}")
  public String selectCourseDetailByCid(@PathVariable("cid") Integer cid, Model model){
    model.addAttribute("course",courseService.selectCourseDetailByCid(cid));
    return "/courseDetail";
  }

}
