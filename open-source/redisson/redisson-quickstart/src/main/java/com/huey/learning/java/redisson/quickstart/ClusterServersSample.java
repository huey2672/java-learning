package com.huey.learning.java.redisson.quickstart;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class ClusterServersSample {

    public static void main(String[] args) {

        Config config = new Config();
        config.useClusterServers()
                .addNodeAddress("redis://127.0.0.1:7000")
                .addNodeAddress("redis://127.0.0.1:7001")
                .addNodeAddress("redis://127.0.0.1:7002");
        RedissonClient redisson = Redisson.create(config);

        // ...

        redisson.shutdown();

    }

}
