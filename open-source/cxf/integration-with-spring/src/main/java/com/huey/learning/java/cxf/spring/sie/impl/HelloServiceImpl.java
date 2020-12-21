package com.huey.learning.java.cxf.spring.sie.impl;

import com.huey.learning.java.cxf.spring.sie.HelloService;

import javax.jws.WebService;

@WebService(endpointInterface = "com.huey.learning.java.cxf.spring.sie.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

}
