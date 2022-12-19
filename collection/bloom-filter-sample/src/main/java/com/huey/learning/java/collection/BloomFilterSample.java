package com.huey.learning.java.collection;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterSample {

    public static void main(String[] args) {

        // 预计插入多少数据
        int expectedInsertions = 1000000;
        // 期望的误判率
        double fpp = 0.01;
        // 创建布隆过滤器
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), expectedInsertions, fpp);

        int total = expectedInsertions;
        for (int i = 0; i < total; i++) {
            // 插入数据
            bloomFilter.put(i);
        }

        int fpc = 0;
        for (int i = total; i < total * 2; i++) {
            // 判断是否包含元素
            if (bloomFilter.mightContain(i)) {
                fpc++;
            }
        }

        System.out.printf("总共误判 %s 个元素，误判率：%.4f%n", fpc, fpc * 1.0 / total);

    }

}
