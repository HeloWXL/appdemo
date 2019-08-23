package com.qztc.appdemo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qztc.appdemo.model.Sign;

/**
 * 签到Mapper
 * @author xiayj
 * @since
 */
public interface SignMapper extends BaseMapper<Sign> {

    /**
     * 添加一条签到信息
     * @param record
     * @return
     */
    int insertSelective(Sign record);

    /**
     * 根据签到ID查询签到信息
     * @param signId
     * @return
     */
    Sign selectByPrimaryKey(Integer signId);

}