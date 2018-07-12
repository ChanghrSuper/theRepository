package com.chr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chr.dao")//指定到接口所在的包
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


}
