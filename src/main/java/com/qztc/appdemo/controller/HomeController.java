package com.qztc.appdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangxl
 * @ClassName HomeController
 * @Description
 * @date 2019/8/21 16:41
 */
@Controller
public class HomeController {

  @GetMapping("/toLogin")
  public String toLogin(){
    return "/student/login.html";
  }

  @GetMapping("/toIndex")
  public String toIndex(){
    return "/student/index.html";
  }
}
