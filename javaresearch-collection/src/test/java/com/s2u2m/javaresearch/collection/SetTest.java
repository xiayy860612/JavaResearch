package com.s2u2m.javaresearch.collection;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Amos Xia
 * @date 2018/4/10
 */
public class SetTest {

    @Getter
    @Setter
    public class Item {
        private String name;
        private Integer num;
    }

    @Test
    public void treeSetTest() {
        SortedSet<Item> parts = new TreeSet<>();

    }
}
