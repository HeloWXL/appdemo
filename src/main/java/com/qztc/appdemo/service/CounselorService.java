package com.qztc.appdemo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qztc.appdemo.mapper.CounselorMapper;
import com.qztc.appdemo.model.Counselor;
import com.qztc.appdemo.model.Course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wangxl
 * @ClassName CounselorService
 * @Description
 * @date 2019/8/21 0:02
 */
@Service
public class CounselorService {

  @Resource
  private CounselorMapper counselorMapper;

  /**
   *
   * @param counselorId
   * @return
   */
  public  int deleteByPrimaryKey(Integer counselorId){
    return counselorMapper.deleteByPrimaryKey(counselorId);
  }

  /**
   *
   * @param record
   * @return
   */
  public int insertSelective(Counselor record){
    return counselorMapper.insertSelective(record);
  }

  /**
   *
   * @param counselorId
   * @return
   */
  public  Counselor selectByPrimaryKey(Integer counselorId){
    return counselorMapper.selectByPrimaryKey(counselorId);
  }

  /**
   *
   * @param record
   * @return
   */
  public int updateByPrimaryKeySelective(Counselor record){
    return counselorMapper.updateByPrimaryKeySelective(record);
  }

  /**
   * 获取辅导员列表分页
   * @param pageNo
   * @param pageSize
   * @return
   */
  public Map<String, Object> getCounselorByPage(Integer pageNo, Integer pageSize) {
    EntityWrapper entityWrapper = new EntityWrapper();
    List<Counselor> counselors = counselorMapper.selectPage(new Page<Course>(pageNo,pageSize),entityWrapper);
    int count = counselorMapper.selectCount(entityWrapper);
    Map<String,Object> map = new HashMap<>();
    map.put("list",counselors);
    map.put("count",count);
    return map;
  }
}
