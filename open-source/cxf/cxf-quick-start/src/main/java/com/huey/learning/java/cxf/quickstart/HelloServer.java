package com.huey.learning.java.cxf.quickstart;

import javax.xml.ws.Endpoint;

/**
 * @author huey
 */
public class HelloServer {

    public void publishWebService() {
        HelloService helloService = new HelloServiceImpl();
        String address = "http://www.huey.com:8888/hello";
        Endpoint.publish(address, helloService);
    }

    public static void main(String[] args) {

        try {

            new HelloServer().publishWebService();

            System.out.println("Server Ready...");
            Thread.sleep(5 * 60 * 1000);
            System.out.println("Server Existing...");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Ending...");
        }

    }

}
