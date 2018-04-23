package com.s2u2m.javaresearch.generic;

import lombok.Getter;
import lombok.Setter;
import org.omg.CORBA.ObjectHelper;

/**
 * @author Amos Xia
 * @date 2018/4/23
 */
@Getter
@Setter
public class PairRaw {
    private Object first;
    private Object second;

    public PairRaw() {
        this.first = null;
        this.second = null;
    }
    public PairRaw(Object first, Object second) {
        this.first = first;
        this.second = second;
    }
}
