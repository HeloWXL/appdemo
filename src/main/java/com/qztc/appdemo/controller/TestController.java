package com.qztc.appdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.qztc.appdemo.config.DataResult;
import com.qztc.appdemo.utils.UploadFileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxl
 * @ClassName TestController
 * @Description TODO
 * @date 2019/9/2 13:34
 * @Version 1.0
 */
@Api(tags = "测试接口")
@Controller
public class TestController {


  @ApiOperation(value = "上传文件测试接口")
  @ResponseBody
  @RequestMapping(value = "/uploadAreaFile",method = RequestMethod.POST)
  public DataResult<String> uploadAreaFile(@RequestParam(value = "file", required = false) MultipartFile file){
    DataResult<String> result = new DataResult<>();
    try{
      //上传文件方法，这里需要改成自己项目里上传文件方法
      String filePath = UploadFileUtils.uploadImage(file);
      result.setCode("200");
      result.setBody(filePath);
      result.setMsg("上传成功");

      return result;
    }catch(Exception e){
      result.setCode("500");
      result.setMsg("上传失败");
      return result;
    }

  }
}
