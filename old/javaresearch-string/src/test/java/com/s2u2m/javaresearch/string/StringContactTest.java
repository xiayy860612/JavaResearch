package com.s2u2m.javaresearch.string;

import org.junit.BeforeClass;
import org.junit.Test;

public class StringContactTest {
    private static String append = "123";
    private static int count;

    @BeforeClass
    public static void setUp4Class() {
        count = 10000;
    }

    @Test
    public void stringContact() {
        String orig = "";
        for (int i = 0; i < count; ++i) {
            orig += append;
        }
    }

    @Test
    public void stringBuf() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < count; ++i) {
            buffer.append(append);
        }
        String rst = buffer.toString();
    }

    @Test
    public void stringBuilder() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            builder.append(append);
        }
        String rst = builder.toString();
    }
}
