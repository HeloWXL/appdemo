package com.qztc.appdemo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qztc.appdemo.mapper.LeaveMapper;
import com.qztc.appdemo.model.Course;
import com.qztc.appdemo.model.Leave;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


  /**
   * 获取请假列表分页 -根据学生的学号查询
   * @param pageNo
   * @param pageSize
   * @return
   */
  public Map<String, Object> getLeaveByPage(Integer pageNo, Integer pageSize,Integer studentSno) {
    EntityWrapper entityWrapper = new EntityWrapper();
    Map<String ,Object> map = new HashMap<>();
    Map<String ,Object> data = new HashMap<>();
    map.put("pageNo",(pageNo - 1) * pageSize);
    map.put("pageSize",pageSize);
    map.put("studentSno",studentSno);
    List<Leave> leaveList = leaveMapper.selectLeaveAndStudentByPage(map);
    data.put("list",leaveList);

    entityWrapper.eq("student_sno",studentSno);
    int count = leaveMapper.selectCount(entityWrapper);
    data.put("count",count);
    return data;
  }

  /**
   * 请假列表分页查询
   * @param pageNo
   * @param pageSize
   * @return
   */
  public Map<String, Object> selectByPage(Integer pageNo, Integer pageSize) {
    EntityWrapper entityWrapper = new EntityWrapper();
    Map<String ,Object> map = new HashMap<>();
    Map<String ,Object> data = new HashMap<>();
    map.put("pageNo",(pageNo - 1) * pageSize);
    map.put("pageSize",pageSize);

    List<Leave> leaveList = leaveMapper.selectByPage(map);
    data.put("list",leaveList);

    int count = leaveMapper.selectCount(entityWrapper);
    data.put("count",count);
    return data;
  }


}
