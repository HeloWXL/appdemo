package com.qztc.appdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 * @author xiayj
 * @since
 */
@EnableSwagger2
@SpringBootApplication
@MapperScan("com.qztc.appdemo.mapper")
public class AppdemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppdemoApplication.class, args);
  }


}
