package com.huey.learning.java.logging.history.slf4jwithspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("spring.xml");

        Logger logger = LoggerFactory.getLogger(MainApp.class);
        logger.info("Hello, App!");


    }

}