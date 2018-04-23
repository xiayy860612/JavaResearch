package com.s2u2m.javaresearch.generic;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Amos Xia
 * @date 2018/4/23
 */
@Getter
@Setter
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        this.first = null;
        this.second = null;
    }
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
}
