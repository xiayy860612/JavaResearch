package com.s2u2m.javaresearch.spring.redisBasic.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * RedisCountService
 * Create by Yangyang.xia on 7/23/18
 */
@Service
public class RedisCountService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private final String countName = "count:5:hits";

    public void updateCounter() {
        SessionCallback<Void> scb = new SessionCallback<Void>() {

            @Override
            public <K, V> Void execute(RedisOperations<K, V> operations) throws DataAccessException {
                operations.multi();

                long sec = (Instant.now().getEpochSecond()/5) * 5;


                operations.exec();
                return null;
            }
        };

        redisTemplate.execute(scb);
    }
}
