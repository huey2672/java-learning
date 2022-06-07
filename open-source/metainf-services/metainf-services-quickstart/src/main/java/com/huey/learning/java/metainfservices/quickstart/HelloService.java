package com.huey.learning.java.metainfservices.quickstart;

import org.kohsuke.MetaInfServices;

@MetaInfServices(GreetService.class)
public class HelloService implements GreetService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

}
