package com.s2u2m.javaresearch.iostream;


import org.junit.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class IOStreamReadTest {

    private static String roFilePath;

    @BeforeClass
    public static void classInit() {
        ClassLoader loader = IOStreamReadTest.class.getClassLoader();
        roFilePath = loader.getResource("hello.txt").getPath();
    }

    @Test
    public void readFile() throws IOException {
        FileInputStream stream = new FileInputStream(roFilePath);
        InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);

        StringBuilder builder = new StringBuilder();
        char[] chars = new char[1024];
        int count = reader.read(chars);
        while(count != -1) {
            builder.append(Arrays.copyOf(chars, count));
            count = reader.read(chars);
        }
        reader.close();

        String actual = builder.toString();
        System.out.println("actual: " + actual);
    }

    @Test
    public void readFileByBuf() throws IOException {
        FileInputStream inputStream = new FileInputStream(roFilePath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        InputStreamReader reader = new InputStreamReader(bufferedInputStream);

        StringBuilder builder = new StringBuilder();
        char[] chars = new char[1024];
        int count = reader.read(chars);
        while(count != -1) {
            builder.append(Arrays.copyOf(chars, count));
            count = reader.read(chars);
        }
        reader.close();

        String actual = builder.toString();
        System.out.println("actual: " + actual);
    }
}
