package com.s2u2m.javaresearch.iostream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class IOStreamWriteTest {

    private static String roFilePath;

    @BeforeClass
    public static void classInit() {
        ClassLoader loader = IOStreamReadTest.class.getClassLoader();
        roFilePath = loader.getResource("iostream_w_test.txt").getPath();
    }

    private static final String baseContent = "hello world";
    private Function<Integer, String> func = times -> {
        String rst = baseContent;
        while(--times > 0) {
            rst += baseContent;
        }
        return rst;
    };
    private String content = "";

    @Before
    public void setUp() {
        content = this.func.apply(1000);
    }

    @Test
    public void write2File() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(roFilePath);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        writer.write(content);
        writer.close();
        System.out.println(content);
    }

    @Test
    public void write2FileByBuf() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(roFilePath);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write(content);
        bufferedWriter.close();
        System.out.println(content);
    }

}
