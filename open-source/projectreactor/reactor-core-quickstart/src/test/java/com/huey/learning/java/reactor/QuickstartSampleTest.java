package com.huey.learning.java.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
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
