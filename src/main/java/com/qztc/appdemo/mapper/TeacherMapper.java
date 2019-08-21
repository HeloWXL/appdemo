package com.qztc.appdemo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qztc.appdemo.model.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * 教师Mapper
 * @author xiayj
 * @since
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    /**
     *根据教师ID删除教师信息
     * @param teacherId
     * @return
     */
    int deleteByPrimaryKey(Integer teacherId);

    /**
     * 添加教师信息
     * @param record
     * @return
     */
    int insertSelective(Teacher record);

    /**
     * 根据教师ID查询教师信息
     * @param teacherId
     * @return
     */
    Teacher selectByPrimaryKey(Integer teacherId);

    /**
     * 修改教师信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Teacher record);
}