package com.s2u2m.javaresearch.string;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringTest {

    @Test
    public void immutableString() {
        String s1 = "hello";
        // new一个字符串总是在堆上生成一个新对象
        String s2 = new String("hello");

        // s1, s2存储在不同的位置
        assertFalse(s1 == s2);

        // s1, s2的值相同
        assertTrue(s1.equals(s2));

        // s1, s3都引用字符串的共享存储
        String s3 = "hello";
        assertTrue(s1 == s3);
        assertTrue(s1.equals(s3));

        // 进行拼接后是一个新的字符串对象, 原有对象不修改
        String s4 = s1 + 1;
        // s4是一个新对象
        assertTrue(s4 != s1);
        // s1未改变
        assertTrue("hello".equals(s1));

        String s5 = new String("hello");
        // new一个字符串总是在堆上生成一个新对象, s2和s5是两个不同的对象, 但值相等
        assertTrue(s2 != s5);
        assertTrue(s2.equals(s5));
    }

    @Test
    public void contactLiteralString() {
        /* 反编译代码:
        0: ldc           #13                 // String hello123
        2: astore_1
        3: ldc           #13                 // String hello123
        5: astore_2
         */
        String s2 = "hello123";
        // 直接使用字符串字面量拼接
        String s3 = "hello" + 123;
        assertTrue(s2 == s3);
    }

    @Test
    public void contactString() {
        /* 反编译代码:
        0: ldc           #2		    // String hello
        2: astore_1
        3: new           #8		    // class java/lang/StringBuilder
        6: dup
        7: invokespecial #9		    // Method java/lang/StringBuilder."<init>":()V
        10: aload_1
        11: invokevirtual #10		// Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        14: bipush        123
        16: invokevirtual #11		// Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        19: invokevirtual #12		// Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        22: astore_2
         */
        String s0 = "hello";
        // 使用引用变量s0进行拼接
        String s1 = s0 + 123;
        assertFalse(s0 == s1);
    }

    @Test
    public void contactFinalString() {
        /* 反编译代码:
        0: ldc           #13                 // String hello123
        2: astore_1
        3: ldc           #2                  // String hello
        5: astore_2
        6: ldc           #13                 // String hello123
        8: astore_3
         */
        String s0 = "hello123";
        final String s1 = "hello";
        // 使用final变量s1进行拼接
        String s2 = s1 + 123;
        assertTrue(s0 == s2);
    }
}
