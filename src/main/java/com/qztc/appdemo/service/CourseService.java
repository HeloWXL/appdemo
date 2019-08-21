package com.qztc.appdemo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qztc.appdemo.mapper.CourseMapper;
import com.qztc.appdemo.model.Course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiayj
 * @ClassName CourseService
 * @Description
 * @date 2019/8/21 0:02
 */
@Service
public class CourseService {


  @Resource
  private CourseMapper courseMapper;

  /**
   *
   * @param courseId
   * @return int
   */
  public int deleteByPrimaryKey(Integer courseId){
    return courseMapper.deleteByPrimaryKey(courseId);
  }

  /**
   *
   * @param record
   * @return int
   */
  public int insertSelective(Course record){
    return courseMapper.insertSelective(record);
  }

  /**
   *
   * @param courseId
   * @return Course
   */
  public Course selectByPrimaryKey(Integer courseId){
    return courseMapper.selectByPrimaryKey(courseId);
  }

  /**
   *
   * @param record
   * @return int
   */
  public  int updateByPrimaryKeySelective(Course record){
    return courseMapper.updateByPrimaryKeySelective(record);
  }



  /**
   * 获取课程列表分页
   * @param pageNo
   * @param pageSize
   * @return
   */
  public Map<String, Object> getCourseByPage(Integer pageNo, Integer pageSize) {
    EntityWrapper entityWrapper = new EntityWrapper();
    List<Course> courses = courseMapper.selectPage(new Page<Course>(pageNo,pageSize),entityWrapper);
    int count = courseMapper.selectCount(entityWrapper);
    Map<String,Object> map = new HashMap<>();
    map.put("list",courses);
    map.put("count",count);
    return map;
  }

}
