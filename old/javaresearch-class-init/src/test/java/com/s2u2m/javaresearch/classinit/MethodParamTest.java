package com.s2u2m.javaresearch.classinit;

import static org.junit.Assert.*;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.junit.Test;

public class MethodParamTest {

    @Getter
    @Setter
    @Accessors(chain = true)
    class Obj {
        private int i;
    }

    private void exchange(Obj o1, Obj o2) {
        Obj tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    @Test
    public void exchangeObjs() {
        Obj obj1 = new Obj().setI(10);
        Obj obj2 = new Obj().setI(20);

        // 函数不会对实参变量本身产生影响, 但可以对变量引用的对象产生影响
        exchange(obj1, obj2);
        assertEquals(10, obj1.getI());
        assertEquals(20, obj2.getI());
    }
}
