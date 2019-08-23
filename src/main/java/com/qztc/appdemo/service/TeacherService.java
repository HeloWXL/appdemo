package com.qztc.appdemo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qztc.appdemo.mapper.TeacherMapper;
import com.qztc.appdemo.model.Course;
import com.qztc.appdemo.model.Student;
import com.qztc.appdemo.model.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxl
 * @ClassName TeacherService
 * @Description
 * @date 2019/8/21 0:03
 */
@Service
public class TeacherService {

  @Resource
  private TeacherMapper teacherMapper;


  /**
   *根据教师ID删除教师信息
   * @param teacherId
   * @return
   */
  public int deleteByPrimaryKey(Integer teacherId){
    return teacherMapper.deleteByPrimaryKey(teacherId);
  }

  /**
   * 添加教师信息
   * @param record
   * @return
   */
  public int insertSelective(Teacher record){
    return teacherMapper.insertSelective(record);
  }


  /**
   * 根据教师ID查询教师信息
   * @param teacherId
   * @return
   */
  public Teacher selectByPrimaryKey(Integer teacherId){
    return teacherMapper.selectByPrimaryKey(teacherId);
  }

  /**
   * 修改教师信息
   * @param record
   * @return
   */
  public int updateByPrimaryKeySelective(Teacher record){
    return teacherMapper.updateByPrimaryKeySelective(record);
  }

  /**
   * 获取教师列表分页
   * @param pageNo
   * @param pageSize
   * @return
   */
  public Map<String, Object> getTeacherByPage(Integer pageNo, Integer pageSize) {
    EntityWrapper entityWrapper = new EntityWrapper();
    List<Teacher> teachers = teacherMapper.selectPage(new Page<Course>(pageNo,pageSize),entityWrapper);
    int count = teacherMapper.selectCount(entityWrapper);
    Map<String,Object> map = new HashMap<>();
    map.put("list",teachers);
    map.put("count",count);
    return map;
  }

  /**
   * 根据学号查询辅导员信息 用于登录判断密码是否相一致
   * @param tno
   * @return
   */
  public Teacher selectByTno(String tno){
    return teacherMapper.selectByTno(tno);
  }


}
