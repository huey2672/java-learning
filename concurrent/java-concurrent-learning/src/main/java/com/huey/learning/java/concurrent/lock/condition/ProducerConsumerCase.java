package com.huey.learning.java.concurrent.lock.condition;

import java.util.stream.Stream;

/**
 * @author huey
 */
public class ProducerConsumerCase {

    public static void main(String[] args) {

        Storehouse storehouse = new Storehouse(5);

        Stream.of(
                new Producer("P1", storehouse, 3),
                new Producer("P2", storehouse, 3),
                new Producer("P3", storehouse, 3),
                new Producer("P4", storehouse, 3),
                new Producer("P5", storehouse, 3)
        ).forEach(Thread::start);

        Stream.of(
                new Consumer("C1", storehouse, 5),
                new Consumer("C2", storehouse, 5),
                new Consumer("C2", storehouse, 5)
        ).forEach(Thread::start);

    }

}