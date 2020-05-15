package com.huey.learning.java.jmx.quickstart;

import java.lang.management.ManagementFactory;
import java.util.Scanner;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class MainApp {

    public static void main(String[] args) {

        try {

            // creates a MBeanServer by ManagementFactory
            MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
            // an objectName consists of two parts: domain and key-value pairs
            ObjectName objectName = new ObjectName("com.huey.learning.java.jmx.quickstart:name=SystemProperties");
            // register a MBean
            mbeanServer.registerMBean(new SystemProperties(), objectName);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // keeps the program running and tests the functions of jmx
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String key = scanner.nextLine();
                String value = System.getProperty(key);
                System.out.println(key + ": " + value);
            }
        }

    }

}
