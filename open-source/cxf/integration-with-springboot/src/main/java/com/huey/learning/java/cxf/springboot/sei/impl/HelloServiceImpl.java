package com.huey.learning.java.cxf.springboot.sei.impl;

import com.huey.learning.java.cxf.springboot.sei.HelloService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(endpointInterface = "com.huey.learning.java.cxf.springboot.sei.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

}
