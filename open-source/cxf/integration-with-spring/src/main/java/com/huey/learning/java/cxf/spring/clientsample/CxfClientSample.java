package com.huey.learning.java.cxf.spring.clientsample;

import com.huey.learning.java.cxf.spring.sie.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class CxfClientSample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("client/spring.xml");
        HelloService client = (HelloService) context.getBean("helloClient");
        System.out.println(client.sayHello("Huey"));

    }

}
