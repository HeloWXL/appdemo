package com.qztc.appdemo.controller;

import com.qztc.appdemo.config.DataResult;
import com.qztc.appdemo.model.Counselor;
import com.qztc.appdemo.model.Course;
import com.qztc.appdemo.service.CounselorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @ClassName CounselorController
 * @Description
 * @date 2019/8/21 0:03
 */
@Api(tags = "辅导员接口")
@RestController
@RequestMapping("/counselor")
public class CounselorController {

  private static final Logger LOG = LoggerFactory.getLogger(CounselorController.class);
  @Resource
  private CounselorService counselorService;

  @ApiOperation(value = "添加辅导员信息")
  @PostMapping("/insertCounselor")
  public DataResult<Integer> insertAdmin(@RequestBody Counselor counselor){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(counselorService.insertSelective(counselor));
    return result;
  }

  @ApiOperation(value = "根据ID查询辅导员信息")
  @PostMapping("/selectByCounselorId/{id}")
  public DataResult<Counselor> selectByPrimaryKey(@PathVariable("id") Integer id){
    DataResult<Counselor> result = new DataResult<>();
    result.setBody(counselorService.selectByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "根据ID删除辅导员信息")
  @GetMapping("/deleteByCounselorId/{id}")
  public DataResult<Integer> deleteByCounselorId(@RequestParam("id") Integer id){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(counselorService.deleteByPrimaryKey(id));
    return result;
  }

  @ApiOperation(value = "修改辅导员信息")
  @PostMapping("/updateCounselor")
  public DataResult<Integer> updateCounselor(@RequestBody Counselor counselor){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(counselorService.updateByPrimaryKeySelective(counselor));
    return result;
  }

}
