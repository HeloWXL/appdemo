package com.qztc.appdemo.controller;

import com.qztc.appdemo.config.DataResult;
import com.qztc.appdemo.model.Leave;
import com.qztc.appdemo.service.LeaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wangxl
 * @ClassName LeaveController
 * @Description TODO
 * @date 2019/8/23 17:51
 * @Version 1.0
 */
@Api(tags = "请假接口")
@RequestMapping("/leaveApi")
@RestController
public class LeaveController {

  @Resource
  private LeaveService leaveService;

  @ApiOperation(value = "添加一条请假记录")
  @PostMapping("/insertSelective")
  public DataResult<Integer> insertSelective(@RequestBody Leave leave){
    DataResult<Integer> result = new DataResult<>();
    result.setBody(leaveService.insertSelective(leave));
    return result;
  }

  @ApiOperation(value = "根据id查询请假记录")
  @GetMapping("/selectByPrimaryKey")
  public DataResult<Leave> selectByPrimaryKey(@RequestParam("leaveId") Integer leaveId){
    DataResult<Leave> result = new DataResult<>();
    Leave leave = leaveService.selectByPrimaryKey(leaveId);
    result.setBody(leave);
    return result;
  }


  @ApiOperation(value = "查询请假信息")
  @GetMapping("/selectLeaveByPage")
  public DataResult<Map<String,Object>> selectLeaveByPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSieze") Integer pageSieze){
    DataResult<Map<String,Object>> result = new DataResult<>();
    result.setBody(leaveService.getLeaveByPage(pageNo,pageSieze));
    return result;
  }




}
