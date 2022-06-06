package com.huey.learning.java.druid.spring.quickstart;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.QueryExp;
import javax.sql.DataSource;
import java.lang.management.ManagementFactory;
import java.util.Collections;
import java.util.Set;

public class JmxController {

    public static void main(String[] args) {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        DataSource jdbcTemplate = appCtx.getBean("dataSource", DataSource.class);

        String name = "com.alibaba.druid:type=DruidDataSource,id=*";
        QueryExp query = null;

        Set<ObjectName> objectNames;
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            objectNames = mbs.queryNames(new ObjectName(name), query);
        }
        catch (Exception e) {
            objectNames = Collections.emptySet();
        }

        for (ObjectName objectName : objectNames) {
            System.out.println("objectName = " + objectName);
        }

    }

}
