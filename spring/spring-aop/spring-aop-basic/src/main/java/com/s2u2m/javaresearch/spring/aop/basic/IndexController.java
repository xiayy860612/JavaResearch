package com.s2u2m.javaresearch.spring.aop.basic;

import com.s2u2m.javaresearch.spring.aop.basic.service.IPerform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController create on 2018/9/3
 *
 * @author Amos Xia
 */
@RestController
public class IndexController {

    @Autowired
    private IPerform perform;

    @GetMapping("/aop-test/{input}")
    public String get(@PathVariable("input") String input) {
        return perform.perform(input);
    }

}
