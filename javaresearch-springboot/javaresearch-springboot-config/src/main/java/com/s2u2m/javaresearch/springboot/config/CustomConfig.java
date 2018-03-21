package com.s2u2m.javaresearch.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@PropertySource("classpath:custom-config.properties")
@ConfigurationProperties(prefix = "custom")
public class CustomConfig {
    private Integer id;
    private String name;

    @Value("${custom.age}")
    private Integer userAge;
}
