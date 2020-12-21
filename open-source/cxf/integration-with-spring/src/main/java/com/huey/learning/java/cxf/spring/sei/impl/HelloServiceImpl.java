package com.huey.learning.java.cxf.spring.sei.impl;

import com.huey.learning.java.cxf.spring.sei.HelloService;

import javax.jws.WebService;

@WebService(endpointInterface = "com.huey.learning.java.cxf.spring.sei.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

}
