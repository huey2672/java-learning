package com.huey.learning.java.reactor;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class QuickstartSampleTest {

    @Test
    public void testFlux() {

        List<String> elements = new ArrayList<>();

        Flux.just("a", "b", "c", "d")
                .log()
                .subscribe(elements::add);

        MatcherAssert.assertThat(elements, IsIterableContainingInOrder.contains("a", "b", "c", "d"));

        MatcherAssert.assertThat(elements, IsIterableContainingInAnyOrder.containsInAnyOrder(
                "a", "b", "c", "d"));

    }

    @Test
    public void testMono() {

        Mono.just("foo")
                .log()
                .subscribe(log::info);

    }

    @Test
    public void testMap() {

        List<String> elements = new ArrayList<>();

        Flux.just("hello", ",", "project", "reactor", "!")
                .map(String::toUpperCase)
                .subscribe(elements::add);

        MatcherAssert.assertThat(elements,
                IsIterableContainingInOrder.contains("HELLO", ",", "PROJECT", "REACTOR", "!"));

    }

    @Test
    public void testFlatMap() {

        List<String> elements = new ArrayList<>();

        Flux.just("hello", ",", "project", "reactor", "!")
                .flatMap(elem -> Flux.just(elem.toUpperCase().split("")))
                .subscribe(elements::add);

        MatcherAssert.assertThat(elements,
                IsIterableContainingInOrder.contains("H", "E", "L", "L", "O", ",",
                        "P", "R", "O", "J", "E", "C", "T", "R", "E", "A", "C", "T", "O", "R", "!"));

    }

    @Test
    public void testGenerate() {

        List<Integer> elements = new ArrayList<>();

        FibonacciGenerator.generateFibonacci(10)
                .subscribe(elements::add);

        MatcherAssert.assertThat(elements,
                IsIterableContainingInOrder.contains(0, 1, 1, 2, 3, 5, 8));

    }

}
