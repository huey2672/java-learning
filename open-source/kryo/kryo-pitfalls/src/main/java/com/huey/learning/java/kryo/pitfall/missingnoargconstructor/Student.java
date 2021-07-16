package com.huey.learning.java.kryo.pitfall.missingnoargconstructor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author huey
 */
@Data
@AllArgsConstructor
public class Student {

    private String name;
    private Integer age;

}
