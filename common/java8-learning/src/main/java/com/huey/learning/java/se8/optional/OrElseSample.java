package com.huey.learning.java.se8.optional;

import java.util.Optional;

/**
 * @author huey
 */
public class OrElseSample {

    public OrElseSample() {
        System.out.println("New an instance of OrElseSample.");
    }

    public static void main(String[] args) {
        Optional<OrElseSample> optionalObject = Optional.of(new OrElseSample());
        OrElseSample sampleObject = optionalObject.orElse(new OrElseSample());
    }

}
