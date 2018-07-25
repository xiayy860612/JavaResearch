package com.s2u2m.javaresearch.collection.iterator;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.RandomAccess;

/**
 * IteratorTest
 *
 * @author Amos Xia
 * @date 2018/7/25
 */
public class IteratorTest {

    @Test
    public void test__randomAccess() {
        boolean rst = new ArrayList<Integer>() instanceof RandomAccess;
        System.out.println(rst);
        assertTrue(rst);

        rst = new LinkedList<Integer>() instanceof RandomAccess;
        System.out.println(rst);
        assertFalse(rst);
    }
}
