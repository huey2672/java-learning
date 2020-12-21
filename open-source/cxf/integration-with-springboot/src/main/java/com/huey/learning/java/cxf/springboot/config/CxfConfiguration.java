package com.huey.learning.java.cxf.springboot.config;

import com.huey.learning.java.cxf.springboot.sei.HelloService;
import com.huey.learning.java.cxf.springboot.sei.impl.HelloServiceImpl;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.xml.ws.Endpoint;

/**
 * @author huey
 */
@Configuration
@ImportResource("classpath:META-INF/cxf/cxf.xml")
public class CxfConfiguration {

    @Bean("CXFServlet")
    public ServletRegistrationBean dispatcherServlet() {
        // 注册 CXFServlet，拦截 /ws/ 开头的请求，不设置则默认拦截 /services/*
        return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
    }

    @Bean("helloEndpoint")
    public Endpoint endpoint(SpringBus cxf, HelloService helloService) {
        Endpoint endpoint = new EndpointImpl(cxf, helloService);
        endpoint.publish("/hello");
        return endpoint;
    }


}
