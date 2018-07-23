package com.s2u2m.javaresearch.spring.profile;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;


@Configuration
@ConfigurationProperties(prefix = "s2u2m")
@Getter
@Setter
public class Test2Config {
    private String test;
    private Map<String, String> reuse = new HashMap<>();
}
