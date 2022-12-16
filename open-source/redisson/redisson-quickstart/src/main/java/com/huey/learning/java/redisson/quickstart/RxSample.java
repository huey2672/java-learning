package com.huey.learning.java.redisson.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLongReactive;
import org.redisson.api.RAtomicLongRx;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.api.RedissonRxClient;
import org.redisson.config.Config;

@Slf4j
public class RxSample {

    public static void main(String[] args) {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonRxClient redisson = Redisson.create(config).rxJava();

        RAtomicLongRx atomicLongRx = redisson.getAtomicLong("atomicLong");
        atomicLongRx.incrementAndGet()
                .doOnSuccess(value -> log.info("value = {}", value))
                .subscribe();

        redisson.shutdown();

    }

}
