package com.huey.learning.java.redisson.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class RedissonSpringbootSampleApplicationTests {

    @Resource
    private RedissonClient redisson;

    @Test
    void testRedisson() {

        RAtomicLong atomicLong = redisson.getAtomicLong("atomicLong");
        long value = atomicLong.incrementAndGet();
        log.info("value = {}", value);

    }

}
