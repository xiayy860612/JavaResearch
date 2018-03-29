package com.s2u2m.javaresearch.classinit;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class InitBlockChild extends InitBlockParent {
    protected static int value = 22;

    static {
        System.out.println("InitBlockChild static block value: " + value);
    }

    private String name = "world";
    private int age = 11;

    {
        System.out.println("InitBlockChild block age: " + age);
        System.out.println("InitBlockChild block name: " + name);
        this.age = 23;
    }

    public InitBlockChild(int a) {
        super(a);
        this.age = a;
        System.out.println("InitBlockChild constructor age: " + age);
        System.out.println("InitBlockChild constructor name: " + name);
    }

}
