package com.s2u2m.javaresearch.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ValuableConfigParam {
    @Value("${springboot-config.name}")
    private String name;
}
