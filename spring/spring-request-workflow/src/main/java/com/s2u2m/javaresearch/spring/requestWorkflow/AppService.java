package com.s2u2m.javaresearch.spring.requestWorkflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * class AppService
 *
 * @author xiayy860612
 * @date 2018/5/9
 */
@SpringBootApplication
@ServletComponentScan
public class AppService extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppService.class, args);
    }

}
