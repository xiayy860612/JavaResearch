package com.s2u2m.javaresearch.spring.redisBasic.basic;

import com.s2u2m.javaresearch.spring.redisBasic.ObjData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/hash")
public class RedisHashController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping(value = "/{id}")
    public ObjData get(@PathVariable(value = "id") int id) {
        String key = String.format("obj:%s", id);
        List<Object> properties = Arrays.stream(ObjData.class.getDeclaredFields())
                .map(field -> field.getName()).collect(Collectors.toList());
        List<Object> rst = redisTemplate.opsForHash().multiGet(key, properties);

        ObjData data = new ObjData();
        if (rst.get(0) != null) {
            data.setId(Integer.parseInt((String) rst.get(0)));
        }

        if (rst.get(1) != null) {
            data.setName((String) rst.get(1));
        }
        return data;
    }

    @PostMapping(value = "/{id}")
    public void set(@PathVariable(value = "id") int id) {
        String key = String.format("obj:%s", id);
        ObjData data = new ObjData();
        data.setId(id);
        data.setName("hello world");

        Map<String, Object> properties = new HashMap<>();
        properties.put("id", data.getId().toString());
        properties.put("name", data.getName());
        redisTemplate.opsForHash().putAll(key, properties);
    }
}
