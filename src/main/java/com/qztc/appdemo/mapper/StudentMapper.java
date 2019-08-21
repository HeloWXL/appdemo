package com.qztc.appdemo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qztc.appdemo.model.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生Mapper
 * @author xiayj
 * @since
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    /**
     *根据学生的ID删除学生信息
     * @param studentId
     * @return int
     */
    int deleteByPrimaryKey(Integer studentId);

    /**
     * 添加学生
     * @param record
     * @return int
     */
    int insertSelective(Student record);

    /**
     * 根据学生的ID查询学生信息
     * @param studentId
     * @return  Student
     */
    Student selectByPrimaryKey(Integer studentId);

    /**
     * 修改学生信息
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Student record);
}