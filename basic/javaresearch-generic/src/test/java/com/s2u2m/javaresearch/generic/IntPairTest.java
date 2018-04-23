package com.s2u2m.javaresearch.generic;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntPairTest {

    @Test
    public void test() {
        PairRaw p = new IntPair();
        p.setSecond(10);
        Integer v = (Integer) p.getSecond();
    }

}