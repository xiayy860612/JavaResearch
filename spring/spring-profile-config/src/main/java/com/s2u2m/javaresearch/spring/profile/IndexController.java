package com.s2u2m.javaresearch.spring.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    private TestConfig config;

    @Autowired
    private Test2Config test2Config;

    @GetMapping("/")
    public String getAttr() {
//        String value = String.format("%s: %s", profile, config.getName());
//        return value
        return test2Config.getReuse().get("url");
    }

}
