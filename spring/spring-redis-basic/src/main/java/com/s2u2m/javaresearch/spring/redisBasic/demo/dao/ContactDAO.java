package com.s2u2m.javaresearch.spring.redisBasic.demo.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * ContactDAO
 * Create by Yangyang.xia on 7/26/18
 */
@Repository
public class ContactDAO {

    private static final String recentKey = "recent";
    private static final int maxCount = 5;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    public List<String> getContactByPrefix(String prefix) {
        SessionCallback<List<String>> cb = new SessionCallback<List<String>>() {
            @Override
            public List<String> execute(RedisOperations operations) throws DataAccessException {
                ListOperations op =operations.opsForList();

                List<String> rst = op.range(recentKey, 0, maxCount);
                return rst;
            }
        };

        List<String> rst = redisTemplate.execute(cb);
        return rst.stream()
            .filter((contact) -> contact.startsWith(prefix))
            .collect(Collectors.toList());
    }

    public void addRecentContact(String name) {
        SessionCallback cb = new SessionCallback() {
            @Override
            public Void execute(RedisOperations operations) throws DataAccessException {
                ListOperations op =operations.opsForList();
                op.remove(recentKey, 0, name);
                op.leftPush(recentKey, name);
                op.trim(recentKey, 0, maxCount);
                return null;
            }
        };

        redisTemplate.execute(cb);
    }

    public void removeRecentContact(String name) {

    }
}
