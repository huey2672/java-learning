package com.huey.learning.kafka.mybugs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author huey
 */
public class HashSetDuplicateElementsSample {

    public static void main(String[] args) {

        Set<Element> set = new HashSet<>();
        Element one = new Element("1", "one");
        set.add(one);
        Element two = new Element("2", "TWO");
        set.add(two);
        Element three = new Element("3", "THREE");
        set.add(three);

        one.setValue("ONE");
        set.add(one);

        set.forEach(System.out::println);

    }

    @Data
    @AllArgsConstructor
    public static class Element {
        private String id;
        private String value;
    }

}
