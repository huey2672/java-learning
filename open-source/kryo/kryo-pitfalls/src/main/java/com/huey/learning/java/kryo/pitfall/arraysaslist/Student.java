package com.huey.learning.java.kryo.pitfall.arraysaslist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;
    private Integer age;
    List<Double> scores;

}
