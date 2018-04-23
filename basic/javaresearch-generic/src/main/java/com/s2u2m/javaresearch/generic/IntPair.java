package com.s2u2m.javaresearch.generic;

import lombok.Getter;
import lombok.Setter;

/**
 * Pair<Integer>由编译器生成的参考代码
 * @author Amos Xia
 * @date 2018/4/23
 */
@Getter
@Setter
public class IntPair extends PairRaw {

    public void setSecond(Integer second) {
        super.setSecond(second);
    }

    /**
     * 通过桥方法来调用类本身对应的方法
     * @param second
     */
    @Override
    public void setSecond(Object second) {
        this.setSecond((Integer)second);
    }

    /**
     * 擦除返回类型, 编译器强制插入类型转换
     * @return
     */
    @Override
    public Integer getSecond() {
        return (Integer) super.getSecond();
    }
}
