package com.s2u2m.javaresearch.iostream;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class SerializableTestObject implements Serializable {
    private Integer id;
    private String value;
}
