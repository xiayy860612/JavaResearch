package com.s2u2m.javaresearch.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionTest {

    @Test
    public void iteratorNext() {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("world");
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }
    }

    @Test
    public void foreachTest() {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("world");
        for (String value : collection) {
            System.out.println(value);
        }
    }

    @Test
    public void listAdd() {
        List<String> collection = new LinkedList<>();
        collection.add("hello");
        collection.add("world");
        for (String value : collection) {
            System.out.println(value);
        }

        ListIterator<String> listIterator = collection.listIterator();
        listIterator.next();
        listIterator.add("yeyeye");

        for (String value : collection) {
            System.out.println(value);
        }
    }

    @Test
    public void listRemove__suc() {
        List<String> collection = new LinkedList<>();
        collection.add("hello");
        collection.add("world");
        collection.add("yeyeye");
        collection.forEach(v -> System.out.println(v));

        Iterator<String> iterator = collection.iterator();
        iterator.next();
        iterator.remove();
        collection.forEach(v -> System.out.println(v));
    }

    @Test
    public void listRemove__fail() {
        List<String> collection = new LinkedList<>();
        collection.add("hello");
        collection.add("world");
        collection.add("yeyeye");
        collection.forEach(v -> System.out.println(v));

        Iterator<String> iterator = collection.iterator();
        iterator.next();
        iterator.remove();
        // IllegalStateException
        iterator.remove();
        collection.forEach(v -> System.out.println(v));
    }

    @Test
    public void listModMonitor() {
        List<String> collection = new LinkedList<>();
        collection.add("hello");
        collection.add("world");
        collection.add("yeyeye");
        collection.forEach(v -> System.out.println(v));

        Iterator<String> iteratorOrg = collection.iterator();

        Iterator<String> iterator = collection.iterator();
        iterator.next();
        iterator.remove();

        // Debug, check expectModCount
        Iterator<String> iterator1 = collection.iterator();

        iterator.forEachRemaining(v -> System.out.println(v));
    }


}