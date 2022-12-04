package com.huey.learning.java.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickstartSampleTest {

    @Test
    public void testFlux() {

        List<String> elements = new ArrayList<>();

        Flux.just("a", "b", "c", "d")
                .log()
                .subscribe(elements::add);

        assertThat(elements, equalTo(Arrays.asList("a", "b", "c", "d")));

    }

    @Test
    public void testMono() {
        Mono.just("foo")
                .log()
                .subscribe(System.out::println);
    }

}
