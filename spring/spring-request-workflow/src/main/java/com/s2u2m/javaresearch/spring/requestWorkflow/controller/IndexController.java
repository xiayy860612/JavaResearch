package com.s2u2m.javaresearch.spring.requestWorkflow.controller;

import com.s2u2m.javaresearch.spring.requestWorkflow.utils.propertyeditor.TestProperty;
import com.s2u2m.javaresearch.spring.requestWorkflow.utils.resolver.HeaderToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/{tp}")
    public TestProperty getId(@RequestBody String id, @PathVariable TestProperty tp) {
        log.info("IndexController getId");
        return tp;
    }

    @GetMapping(value = "/ex")
    public void ex() {
        throw new RuntimeException("IndexController ex");
    }

    @GetMapping(value = "/resolver")
    public HeaderToken getToken(HeaderToken token) {
        return token;
    }
}
