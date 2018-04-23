package com.s2u2m.javaresearch.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "springboot-config.confprop")
public class PrefixConfigParams {
    private Integer id;
    private String name;

    @Value("${springboot-config.confprop.age}")
    private Integer userAge;
}
