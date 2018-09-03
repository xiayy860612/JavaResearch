package com.s2u2m.javaresearch.spring.aop.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * PerformService create on 2018/9/3
 *
 * @author Amos Xia
 */
@Slf4j
@Service
public class PerformService implements IPerform {
    @Override
    public String perform(String input) {
        log.info("Execute Perform:" + input);
        return input;
    }
}
