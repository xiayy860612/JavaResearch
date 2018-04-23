package com.s2u2m.javaresearch.springboot.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrefixConfigParamsTest {

    @Autowired
    PrefixConfigParams params;

    @Test
    public void testConfigProperty() {
        assertEquals(1, params.getId().intValue());
    }

    @Test
    public void testValueInPrefixProperty() {
        assertEquals(18, params.getUserAge().intValue());
    }

}