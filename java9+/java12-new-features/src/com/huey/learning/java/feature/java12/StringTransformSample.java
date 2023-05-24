package com.huey.learning.java.feature.java12;

import java.util.Arrays;

public class StringTransformSample {

    public static void main(String[] args) {

        String text = "Boats sail on the rivers,\n" +
                "And ships sail on the seas;\n" +
                "But clouds that sail across the sky,\n" +
                "Are prettier far than these. ";

        String[] sentences = text.transform(value -> value.toUpperCase().split("\n"));

        Arrays.stream(sentences).forEach(System.out::println);

    }

}
