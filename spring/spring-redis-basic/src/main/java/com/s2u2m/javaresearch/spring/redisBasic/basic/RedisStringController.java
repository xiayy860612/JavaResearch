package com.s2u2m.javaresearch.spring.redisBasic.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/string")
public class RedisStringController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/{key}")
    public String getKey(@PathVariable("key") String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @PostMapping(value = "/{key}/{value}")
    public void setKey(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
