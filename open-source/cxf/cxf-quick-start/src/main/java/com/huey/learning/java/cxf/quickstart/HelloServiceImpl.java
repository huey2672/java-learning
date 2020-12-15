package com.huey.learning.java.cxf.quickstart;

/**
 * @author huey
 */

import javax.jws.WebService;

@WebService(endpointInterface = "com.huey.learning.java.cxf.quickstart.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

}
