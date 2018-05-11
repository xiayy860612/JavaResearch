package com.s2u2m.javaresearch.spring.requestWorkflow.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class IndexController
 *
 * @author xiayy860612
 * @date 2018/5/9
 */
@Slf4j
@RestController
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        log.info("IndexController execute");
        return "IndexController";
    }
}
