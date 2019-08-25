package com.qztc.appdemo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qztc.appdemo.model.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 课程Mapper
 * @author xiayj
 * @since
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    /**
     * 根据课程的id删除课程信息
     * @param courseId
     * @return
     */
    int deleteByPrimaryKey(Integer courseId);

    /**
     * 添加课程信息
     * @param record
     * @return
     */
    int insertSelective(Course record);

    /**
     * 根据课程的id查询课程信息
     * @param courseId
     * @return
     */
    Course selectByPrimaryKey(Integer courseId);

    /**
     * 修改课程信息
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Course record);


    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Course>  selectCourseByPage(Map<String,Object> map);

}