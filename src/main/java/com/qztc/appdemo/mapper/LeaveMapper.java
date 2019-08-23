package com.qztc.appdemo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qztc.appdemo.model.Leave;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author
 * @since
 */
@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {

    /**
     * 添加
     * @param record
     * @return
     */
    int insertSelective(Leave record);

    /**
     * 根据ID查询请假信息
     * @param leaveId
     * @return
     */
    Leave selectByPrimaryKey(Integer leaveId);

}