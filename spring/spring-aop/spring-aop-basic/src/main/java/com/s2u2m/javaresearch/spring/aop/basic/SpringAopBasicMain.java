package com.s2u2m.javaresearch.spring.aop.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;

/**
 * SpringAopBasicMain create on 2018/9/3
 *
 * @author Amos Xia
 */
@SpringBootApplication
public class SpringAopBasicMain extends SpringServletContainerInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopBasicMain.class, args);
    }
}
