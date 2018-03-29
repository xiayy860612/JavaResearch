package com.s2u2m.javaresearch.classinit;

import lombok.Getter;

@Getter
public class FieldOverrideObj {
    private String name = "hello";
    private int age = 0;

    public FieldOverrideObj(String n, int a) {
        // 同名变量慧隐藏外部域的同名变量
        String name = n;
        int age = a;

        System.out.println(age);
    }
}
