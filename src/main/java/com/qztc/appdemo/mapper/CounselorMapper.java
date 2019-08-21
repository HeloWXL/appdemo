package com.qztc.appdemo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qztc.appdemo.model.Counselor;
import org.apache.ibatis.annotations.Mapper;

/**
 * 辅导员Mapper
 * @author xiayj
 * @since
 */
@Mapper
public interface CounselorMapper extends BaseMapper<Counselor> {
    /**
     * 根据Id删除辅导员
     * @param counselorId
     * @return int
     */
    int deleteByPrimaryKey(Integer counselorId);


    /**
     * 添加辅导员
     * @param record
     * @return int
     */
    int insertSelective(Counselor record);

    /**
     * 根据ID删除辅导员信息
     * @param counselorId
     * @return Counselor
     */
    Counselor selectByPrimaryKey(Integer counselorId);

    /**
     * 修改辅导员信息
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Counselor record);


}