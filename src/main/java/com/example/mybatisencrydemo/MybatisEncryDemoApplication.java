package com.example.mybatisencrydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.mybatisencrydemo.mapper"})
public class MybatisEncryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisEncryDemoApplication.class, args);
    }

}
