package com.huey.learning.java.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureSample {

    public static void main(String[] args) {

        CompletableFuture<byte[]> downloadFuture = CompletableFuture.supplyAsync(() -> {
            // 下载文件并得到文件内容
            byte[] file = new byte[0];
//            throw new  RuntimeException();
             return file;
        });
//        CompletableFuture<byte[]> failedDownloadFuture = downloadFuture.exceptionally(e -> {
//            System.err.println("下载文件错误：" + e.getMessage());
//            return null;
//        });
//        CompletableFuture<Integer> countFuture = downloadFuture.thenApply((file) -> {
//            System.out.println("下载文件完毕：" + file);
//            int count = 0;
//            return count;
//        });

        CompletableFuture<byte[]> completedFuture = downloadFuture.whenComplete((file, e) -> {
            if (file != null) {
                System.out.println("下载文件完毕");
            }
            else if (e != null) {
                System.out.println("下载文件错误");
            }
        });

        CompletableFuture<Integer> firstFuture = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("f");
//            return 1;
        });

        CompletableFuture<Integer> secondFuture = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("s");
//            return 2;
        });

        CompletableFuture<Integer> thirdFuture = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("f");
//            return 1;
        });

        CompletableFuture<Void> combinedFuture = secondFuture.runAfterBoth(firstFuture, () -> {

            System.out.println("1");
        });

        CompletableFuture.allOf(firstFuture, secondFuture, thirdFuture).thenRun(() -> {

        });

//        try {
//            combinedFuture.get();
//        }
//        catch (InterruptedException | ExecutionException e) {
//            System.err.println("e");
//            e.printStackTrace();
//        }

        combinedFuture.exceptionally(e -> {
            System.out.println("e = " + e.getClass());
            e.printStackTrace();
            return null;
        });

        System.out.println("2");
        sleep(10);



    }

    static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
