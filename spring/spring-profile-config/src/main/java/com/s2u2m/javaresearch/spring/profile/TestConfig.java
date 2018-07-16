package com.s2u2m.javaresearch.spring.profile;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:config/test-${spring.profiles.active}.properties")
@ConfigurationProperties(prefix = "s2u2m.test")
@Getter
@Setter
public class TestConfig {
    private String name;
}
