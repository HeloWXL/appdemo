package com.qztc.appdemo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qztc.appdemo.model.Course;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author
 * @since
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    /**
     *
     * @param courseId
     * @return
     */
    int deleteByPrimaryKey(Integer courseId);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Course record);

    /**
     *
     * @param courseId
     * @return
     */
    Course selectByPrimaryKey(Integer courseId);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Course record);
}