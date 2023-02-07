package com.huey.learning.elasticjob.lite;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyJob implements SimpleJob {

    private static final Logger logger = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(ShardingContext context) {
        logger.info("Do something by sharding item " + context.getShardingItem());
    }

    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(new String[]{"1", "2", "3"}));
    }

}
