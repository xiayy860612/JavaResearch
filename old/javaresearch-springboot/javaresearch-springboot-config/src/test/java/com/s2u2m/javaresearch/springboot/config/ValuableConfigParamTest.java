package com.s2u2m.javaresearch.springboot.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValuableConfigParamTest {
    @Autowired
    ValuableConfigParam configParam;

    @Test
    public void testValuableConfigParam() {
        assertTrue(configParam.getName().equals("world"));
    }

}