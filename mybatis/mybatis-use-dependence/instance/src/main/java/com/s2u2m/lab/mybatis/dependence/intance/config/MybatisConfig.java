package com.s2u2m.lab.mybatis.dependence.intance.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {
    "com.s2u2m.lab.mybatis.dependence.intance.mapper",
    "com.s2u2m.lab.mybatis.dependence.basic.mapper"
})
public class MybatisConfig {
}
