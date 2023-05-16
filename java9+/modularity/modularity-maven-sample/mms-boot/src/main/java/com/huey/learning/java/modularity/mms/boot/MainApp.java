package com.huey.learning.java.modularity.mms.boot;

import com.huey.learning.java.modularity.mms.service.HelloService;

public class MainApp {

    public static void main(String[] args) {
        HelloService helloService = new HelloService();
        helloService.sayHello("Huey");
    }

}
