package com.huey.learning.java.redisson.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

@Slf4j
public class RedissonSample {

    public static void main(String[] args) {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        RAtomicLong atomicLong = redisson.getAtomicLong("atomicLong");
        long value = atomicLong.incrementAndGet();
        log.info("value = {}", value);

        redisson.shutdown();

    }

}
