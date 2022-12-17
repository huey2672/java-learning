package com.huey.learning.java.redisson.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.locks.Lock;

@Slf4j
public class RLockSample {

    public static void main(String[] args) {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        Lock lock = redisson.getLock("lock");
        lock.lock();
        try {
            // access the resource protected by this lock
        }
        finally {
            lock.unlock();
        }

        redisson.shutdown();

    }

}
