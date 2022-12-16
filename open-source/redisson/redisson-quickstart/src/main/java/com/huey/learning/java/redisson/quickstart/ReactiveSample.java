package com.huey.learning.java.redisson.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLongReactive;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.config.Config;

@Slf4j
public class ReactiveSample {

    public static void main(String[] args) {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonReactiveClient redisson = Redisson.create(config).reactive();

        RAtomicLongReactive atomicLongReactive = redisson.getAtomicLong("atomicLong");
        atomicLongReactive.incrementAndGet()
                .subscribe(value -> log.info("value = {}", value));

        redisson.shutdown();

    }

}
