package com.s2u2m.javaresearch.spring.aop.basic.aop;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * PerformAspect create on 2018/9/3
 *
 * @author Amos Xia
 */
@Slf4j
@Aspect
@Component
public class PerformAspect {

    @Pointcut("execution(** com.s2u2m..*.IPerform.perform(..)) " +
            "&& within(com.s2u2m.javaresearch.spring.aop.basic..*)")
    public void perform() {
    }

    @Pointcut("execution(** com.s2u2m..*.perform(..)) " +
            "&& target(com.s2u2m.javaresearch.spring.aop.basic.service.IPerform)")
    public void perform2() {
    }

    @Pointcut("execution(** com.s2u2m..*.perform(String)) " +
            "&& target(com.s2u2m.javaresearch.spring.aop.basic.service.IPerform) " +
            "&& args(input)")
    public void perform3(String input) {
    }


    @Before("perform3(input)")
    public void beforePerform(JoinPoint joinPoint, String input) {
        log.info("Before Perform: " + input);
    }

    @AfterReturning(value = "perform2()", returning = "output")
    public void afterPerform(String output) {
        log.info("After Perform: " + output);
    }
}
