package com.huey.learning.java.cxf.quickstart;

import javax.jws.WebService;

/**
 * @author huey
 */
@WebService(targetNamespace = "http://www.huey.com")
public interface HelloService {

    String sayHello(String name);

}
