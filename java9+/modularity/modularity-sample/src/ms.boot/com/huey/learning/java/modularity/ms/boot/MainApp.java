package com.huey.learning.java.modularity.ms.boot;

import com.huey.learning.java.modularity.ms.service.HelloService;

public class MainApp {

    public static void main(String[] args) {
        HelloService helloService = new HelloService();
        helloService.sayHello("Huey");
    }

}

