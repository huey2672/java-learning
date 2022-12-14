package com.huey.learning.java.reactor;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

public class FibonacciGenerator {

    public static Flux<Integer> generateFibonacci(int limit) {

        return Flux.generate(
                () -> Tuples.of(0, 1),
                (state, sink) -> {
                    sink.next(state.getT1());
                    if (state.getT2() > limit) {
                        sink.complete();
                    }
                    return Tuples.of(state.getT2(), state.getT1() + state.getT2());
                }
        );
    }

}
