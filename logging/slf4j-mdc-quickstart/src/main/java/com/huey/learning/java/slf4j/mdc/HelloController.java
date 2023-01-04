package com.huey.learning.java.slf4j.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("hello")
    public String sayHello() {
        logger.info("Hello, World");
        return "Hello, World";
    }

}
