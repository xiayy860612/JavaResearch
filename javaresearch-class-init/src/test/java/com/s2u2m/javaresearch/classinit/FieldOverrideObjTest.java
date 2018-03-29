package com.s2u2m.javaresearch.classinit;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldOverrideObjTest {

    @Test
    public void fieldOverride() {
        String name = "xiayy";
        int age = 10;
        FieldOverrideObj obj = new FieldOverrideObj(name, age);

        assertEquals(0, obj.getAge());
    }
}