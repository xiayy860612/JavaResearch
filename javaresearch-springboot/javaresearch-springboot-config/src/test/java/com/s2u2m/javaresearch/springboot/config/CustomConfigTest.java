package com.s2u2m.javaresearch.springboot.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomConfigTest {

    @Autowired
    CustomConfig customConfig;

    @Test
    public void testCustomConfig() {
        assertEquals(1, customConfig.getId().intValue());
    }

    @Test
    public void testValueInCustomConfig() {
        assertEquals(18, customConfig.getUserAge().intValue());
    }
}