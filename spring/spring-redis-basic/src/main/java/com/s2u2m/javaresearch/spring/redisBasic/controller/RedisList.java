package com.s2u2m.javaresearch.spring.redisBasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.s2u2m.javaresearch.spring.redisBasic.service.RedisLogService;

/**
 * RedisList
 * Create by Yangyang.xia on 7/23/18
 */
@RestController
public class RedisList {

    @Autowired
    private RedisLogService logService;

    @PostMapping(value = "/new/log")
    public void log(@RequestParam("name") String name, @RequestParam("msg") String msg) {
        logService.logRecent(name, msg);
    }

    @GetMapping(value = "/logs")
    public List<String> logs() {
        return logService.getRecLogs();
    }
}
