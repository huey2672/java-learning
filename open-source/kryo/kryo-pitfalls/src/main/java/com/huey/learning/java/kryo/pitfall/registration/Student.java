package com.huey.learning.java.kryo.pitfall.registration;

import lombok.Data;

import java.util.List;

@Data
public class Student {

    private String name;

    private List<Double> scores;

    private Address address;

}
