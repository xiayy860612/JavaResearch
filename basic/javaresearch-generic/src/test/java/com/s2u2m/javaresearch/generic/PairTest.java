package com.s2u2m.javaresearch.generic;

import lombok.Getter;
import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {
    @Test
    public void test() throws Exception {
        Pair<Integer> ip = new Pair<>(10, 20);
        System.out.println(ip.getClass().getName());  // com.s2u2m.javaresearch.generic.Pair

        Pair<String> ips = new Pair<>("hello", "world");
        System.out.println(ip.getClass().getName());  // com.s2u2m.javaresearch.generic.Pair
    }

    private <T> void print(Pair<T> p) {
        System.out.println(p.getFirst().toString());
        System.out.println(p.getSecond().toString());
    }

    private class Empoyee {
        private String name;

        public Empoyee(String n) {
            this.name = n;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    private void print2(Pair<? extends Empoyee> p) {
        System.out.println(p.getFirst().toString());
        System.out.println(p.getSecond().toString());
    }

    @Test
    public void testFix() {
        Pair<String> ips = new Pair<>("hello", "world");
        print(ips);

        Pair<Empoyee> ep = new Pair<>(new Empoyee("yeye"), new Empoyee("qweqwe"));
        print(ep);
    }

    @Test
    public void testWildchard() {
//        Pair<String> ips = new Pair<>("hello", "world");
//        print2(ips); // compile error

        Pair<Empoyee> ep = new Pair<>(new Empoyee("yeye"), new Empoyee("qweqwe"));
        print2(ep);
    }

    private class Manager extends Empoyee {

        @Getter
        private int age = 10;

        public Manager(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Manager " + super.toString() + ": " + age;
        }
    }

    private void print3(Pair<Empoyee> pe) {
        System.out.println(pe.getFirst().name);
        System.out.println(pe.getSecond().name);
    }

    @Test
    public void testWildcard2() {
        Empoyee e1 = new Empoyee("e1");
        Empoyee e2 = new Empoyee("e2");
        Pair<Empoyee> ep = new Pair<>(e1, e2);
        print3(ep);

        Manager m1 = new Manager("m1");
        Manager m2 = new Manager("m2");
        Pair<Manager> mp = new Pair<>(m1, m2);
//        print3(mp); // compile error

        // wildchart ok
        print2(mp);

        Pair<? extends Empoyee> wp = mp;
//        wp.setFirst(e1); // compile error
        Empoyee e3 = wp.getFirst();
        System.out.println(e3);
    }

    private void print4(Pair<? super Manager> pm) {
        Manager m1 = new Manager("print4");
        Empoyee e1 = new Empoyee("e1-print4");
//        pm.setFirst(e1); // compile error
        pm.setFirst(m1);
        System.out.println(pm);
    }

    @Test
    public void testWildcard3() {
        Manager m1 = new Manager("m1");
        Manager m2 = new Manager("m2");
        Pair<Manager> mp = new Pair<>(m1, m2);
        print4(mp);
    }

    <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }

    void swap(Pair<?> p) {
        // T 捕获 ?的类型
        swapHelper(p);
    }

    @Test
    public void testSwap() {
        Empoyee e1 = new Empoyee("e1");
        Empoyee e2 = new Empoyee("e2");
        Pair<Empoyee> ep = new Pair<>(e1, e2);

        print2(ep);
        swap(ep);
        print2(ep);
    }

}