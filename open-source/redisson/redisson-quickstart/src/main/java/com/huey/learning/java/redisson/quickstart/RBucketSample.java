package com.huey.learning.java.redisson.quickstart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.Serializable;

@Slf4j
public class RBucketSample {

    public static void main(String[] args) {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        RBucket<SimpleObject> bucket = redisson.getBucket("bucket");

        bucket.set(new SimpleObject("foo"));
        SimpleObject foo = bucket.get();

        bucket.compareAndSet(new SimpleObject("foo"),  new SimpleObject("bar"));
        SimpleObject bar = bucket.get();

        redisson.shutdown();

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class SimpleObject implements Serializable {

        private String value;

    }

}
