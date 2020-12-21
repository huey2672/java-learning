package com.huey.learning.java.cxf.spring.sei;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author huey
 */
@WebService(targetNamespace = "http://www.huey.com")
public interface HelloService {

    String sayHello(@WebParam(name = "name") String name);

}
