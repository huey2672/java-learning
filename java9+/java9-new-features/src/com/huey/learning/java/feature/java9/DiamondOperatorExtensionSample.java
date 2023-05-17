package com.huey.learning.java.feature.java9;

import java.util.Comparator;

public class DiamondOperatorExtensionSample {

    public static void main(String[] args) {

        Comparator<Object> comparator = new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

        };

    }

}
