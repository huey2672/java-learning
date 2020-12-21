package com.huey.learning.java.cxf.springboot.sei;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.huey.com")
public interface HelloService {

    String sayHello(@WebParam(name = "name") String name);

}