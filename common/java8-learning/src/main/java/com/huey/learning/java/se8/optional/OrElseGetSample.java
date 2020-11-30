package com.huey.learning.java.se8.optional;

import java.util.Optional;

/**
 * @author huey
 */
public class OrElseGetSample {

    public OrElseGetSample() {
        System.out.println("New an instance of OrElseGetSample.");
    }

    public static void main(String[] args) {
        Optional<OrElseGetSample> optionalObject = Optional.of(new OrElseGetSample());
        OrElseGetSample sampleObject = optionalObject.orElseGet(() -> new OrElseGetSample());
    }

}
