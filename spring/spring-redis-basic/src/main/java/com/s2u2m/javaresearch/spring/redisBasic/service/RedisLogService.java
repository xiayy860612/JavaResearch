package com.s2u2m.javaresearch.spring.redisBasic.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * RedisLogService
 * Create by Yangyang.xia on 7/23/18
 */
@Service
public class RedisLogService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private String key = "rec_logs";

    public void logRecent(String name, String msg) {

        String log = String.format("%s %s: %s", Instant.now().toString(), name, msg);

        SessionCallback<Void> scb = new SessionCallback<Void>() {
            @Override
            public Void execute(RedisOperations operations) throws DataAccessException {
                operations.multi();

                BoundListOperations ops = operations.boundListOps(key);
                ops.leftPush(log);
                ops.trim(0, 99);

                operations.exec();

                return null;
            }
        };

        redisTemplate.execute(scb);
    }

    public List<String> getRecLogs() {
        return redisTemplate.opsForList().range(key, 0, 10);
    }
}
