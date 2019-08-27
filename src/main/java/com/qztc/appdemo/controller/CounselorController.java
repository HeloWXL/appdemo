package com.qztc.appdemo.controller;

import com.qztc.appdemo.config.DataResult;
import com.qztc.appdemo.model.Counselor;
import com.qztc.appdemo.model.Course;
import com.qztc.appdemo.model.Profession;
import com.qztc.appdemo.model.Teacher;
import com.qztc.appdemo.service.CounselorService;
import com.qztc.appdemo.service.ProfessionService;
import com.qztc.appdemo.utils.Md5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xiayj
 * @ClassName CounselorController
 * @Description
 * @date 2019/8/21 0:03
 */
@Api(tags = "辅导员接口")
@RestController
@RequestMapping("/counselorApi")
public class CounselorController {

  private static final Logger LOG = LoggerFactory.getLogger(CounselorController.class);
  @Resource
  private CounselorService counselorService;
  @Resource
  private ProfessionService professionService;

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


  @ApiOperation(value = "辅导员登录")
  @PostMapping("/checkLogin")
  public DataResult<Boolean> checkLogin(@RequestParam("cno") String cno, @RequestParam("password") String password, HttpServletRequest request){
    Counselor counselor = counselorService.selectByCno(cno);
    DataResult<Boolean> result = new DataResult<>();
    if (Md5Utils.getSaltverifyMD5(password, counselor.getCounselorPassword())) {
      //根据专业的ID获取教师的专业相关信息
      Profession profession = professionService.selectByPrimaryKey(counselor.getProfessionId());
      counselor.setProfession(profession);
      result.setBody(true);
      request.getSession().setAttribute("counselorsession", counselor);
    } else {
      request.getSession().setAttribute("counselorsession", null);
      result.setBody(false);
    }
    return result;
  }

  @ApiOperation(value = "获取辅导员的session对象")
  @PostMapping("/getCounselorSession")
  public DataResult<Counselor> getTeacherSession(HttpServletRequest request,@RequestParam("counselorrBean") String counselorrBean){
    DataResult<Counselor> result = new DataResult<>();
    Counselor counselor = (Counselor) request.getSession().getAttribute(counselorrBean);
    if (counselor == null) {
      result.setBody(null);
      return result;
    } else {
      result.setBody(counselor);
      return result;
    }
  }


}
