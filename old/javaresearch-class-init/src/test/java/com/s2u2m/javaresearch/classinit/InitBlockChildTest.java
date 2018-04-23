package com.s2u2m.javaresearch.classinit;

import org.junit.Test;

import static org.junit.Assert.*;

public class InitBlockChildTest {

    @Test
    public void initTest() {
        int exp = 44;
        InitBlockChild child = new InitBlockChild(exp);
        assertEquals(exp, child.getAge());
    }

}