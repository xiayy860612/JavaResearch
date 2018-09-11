package com.s2u2m.lab.mybatis.dependence.intance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;

/**
 * MyBatisUseDependenceInstance
 * Create by Yangyang.xia on 9/11/18
 */
@SpringBootApplication
public class MyBatisUseDependenceInstance extends SpringServletContainerInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisUseDependenceInstance.class, args);
    }

}
