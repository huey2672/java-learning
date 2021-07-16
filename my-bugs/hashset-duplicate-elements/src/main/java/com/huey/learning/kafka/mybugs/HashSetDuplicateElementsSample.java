package com.huey.learning.kafka.mybugs;

import java.util.HashSet;

/**
 * @author huey
 */
public class HashSetDuplicateElementsSample {

    public static void main(String[] args) {

        HashSet<Student> students = new HashSet<>();
        Student huey = new Student("Huey", 18);
        students.add(huey);
        Student jack = new Student("Jack", 30);
        students.add(jack);
        Student tony = new Student("Tony", 25);
        students.add(tony);

        huey.setAge(16);
        students.add(huey);

        students.forEach(System.out::println);

    }

}
