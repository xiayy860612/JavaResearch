package com.s2u2m.javaresearch.classinit;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class InitBlockParent {
    protected static int value = 11;

    static {
        System.out.println("InitBlockParent static block value: " + value);
    }

    protected String name = "hello";
    protected int age = 10;

    {
        System.out.println("InitBlockParent block age: " + age);
        System.out.println("InitBlockParent block name: " + name);
        this.age = 20;
    }

    public InitBlockParent(int a) {
        System.out.println("InitBlockParent constructor age: " + age);
        System.out.println("InitBlockParent constructor name: " + name);
        this.age = a + 30;
    }
}
