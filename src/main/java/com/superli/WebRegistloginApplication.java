package com.superli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.superli.loginRegist.regist.mapper")
public class WebRegistloginApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebRegistloginApplication.class, args);
    }

}
