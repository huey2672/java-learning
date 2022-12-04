package com.huey.learning.java.concurrent.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(() -> System.out.println("Hello"));

        Future<Double> future = executorService.submit(Math::random);




        executorService.shutdown();

    }

}
