package com.fan.wanwindow;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gao.dao")
public class WanWindowApplication {

    public static void main(String[] args) {
        SpringApplication.run(WanWindowApplication.class, args);
    }

}
