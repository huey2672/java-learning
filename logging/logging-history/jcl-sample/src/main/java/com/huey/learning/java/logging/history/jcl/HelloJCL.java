package com.huey.learning.java.logging.history.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author huey
 */
public class HelloJCL {

    static final Log logger = LogFactory.getLog(HelloJCL.class);

    public static void main(String[] args) {
        logger.info("Hello, JCL!");
    }

}
