package com.huey.learning.java.cxf.springboot.sei;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.huey.com")
public interface HelloService {

    @WebResult(name = "response")
    String sayHello(@WebParam(name = "name") String name);

}