package com.qztc.appdemo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qztc.appdemo.model.Leave;

/**
 * 请假Mapper
 * @author xiayj
 * @since
 */
public interface LeaveMapper extends BaseMapper<Leave> {

    /**
     * 添加请假条
     * @param record
     * @return int
     */
    int insertSelective(Leave record);

    /**
     * 根据请假条ID查询请假条信息
     * @param leaveId
     * @return Leave
     */
    Leave selectByPrimaryKey(Integer leaveId);


}