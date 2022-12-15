package com.huey.learning.java.redisson.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

import java.io.IOException;
import java.util.concurrent.locks.Lock;

@Slf4j
public class RedissonSample {

    public static void main(String[] args) throws IOException {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        RAtomicLong myAtomicLong = redisson.getAtomicLong("myAtomicLong");
        long longValue = myAtomicLong.addAndGet(10L);
        log.info("longValue = {}", longValue);

        redisson.shutdown();

    }

    public void sampleOfAtomicLong(RedissonClient redisson) {
        RAtomicLong myAtomicLong = redisson.getAtomicLong("myAtomicLong");
        long longValue = myAtomicLong.addAndGet(10L);
        log.info("longValue = {}", longValue);
    }

    public void sampleOfLock(RedissonClient redisson) {
        Lock lock = redisson.getLock("myLock");
        lock.lock();
        try {
            // access the resource protected by this lock
        }
        finally {
            lock.unlock();
        }
    }

}
