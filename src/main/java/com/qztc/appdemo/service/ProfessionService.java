package com.qztc.appdemo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qztc.appdemo.mapper.ProfessionMapper;
import com.qztc.appdemo.model.Course;
import com.qztc.appdemo.model.Profession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiayj
 * @ClassName ProfessionService
 * @Description
 * @date 2019/8/21 0:02
 */
@Service
public class ProfessionService {

  @Resource
  private ProfessionMapper professionMapper;

  /**
   * 根据专业的ID删除专业信息
   * @param professionId
   * @return
   */
  public  int deleteByPrimaryKey(Integer professionId){
    return professionMapper.deleteByPrimaryKey(professionId);
  }

  /**
   * 添加专业信息
   * @param record
   * @return
   */
  public  int insertSelective(Profession record){
    return professionMapper.insertSelective(record);
  }

  /**
   * 根据ID查询专业信息
   * @param professionId
   * @return
   */
  public Profession selectByPrimaryKey(Integer professionId){
    return professionMapper.selectByPrimaryKey(professionId);
  }

  /**
   * 修改专业信息
   * @param record
   * @return
   */
  public  int updateByPrimaryKeySelective(Profession record){
    return professionMapper.updateByPrimaryKeySelective(record);
  }

  /**
   * 获取专业列表分页
   * @param pageNo
   * @param pageSize
   * @return
   */
  public Map<String, Object> getProfessionByPage(Integer pageNo, Integer pageSize) {
    EntityWrapper entityWrapper = new EntityWrapper();
    List<Profession> professions = professionMapper.selectPage(new Page<Course>(pageNo,pageSize),entityWrapper);
    int count = professionMapper.selectCount(entityWrapper);
    Map<String,Object> map = new HashMap<>();
    map.put("list",professions);
    map.put("count",count);
    return map;
  }

}
