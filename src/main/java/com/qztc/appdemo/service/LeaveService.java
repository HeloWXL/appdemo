package com.qztc.appdemo.service;

import com.qztc.appdemo.mapper.LeaveMapper;
import com.qztc.appdemo.model.Leave;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @ClassName LeaveService
 * @Description TODO
 * @date 2019/8/23 17:50
 * @Version 1.0
 */
@Service
public class LeaveService {
  @Resource
  private LeaveMapper leaveMapper;

  /**
   * 添加一条请假记录
   * @param record
   * @return int
   */
  public  int insertSelective(Leave record){
    return leaveMapper.insertSelective(record);
  }

  /**
   * 根据ID查询出请假记录
   * @param leaveId
   * @return
   */
  public Leave selectByPrimaryKey(Integer leaveId){
    return leaveMapper.selectByPrimaryKey(leaveId);
  }


}
