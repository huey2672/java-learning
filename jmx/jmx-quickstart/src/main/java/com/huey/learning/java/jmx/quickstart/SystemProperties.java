package com.huey.learning.java.jmx.quickstart;

/**
 * MBean, if the interface name is XxxMBean, the MBean's name must be Xxx
 *
 * @author huey
 */
public class SystemProperties implements SystemPropertiesMBean {

    @Override
    public void setSystemProperty(String key, String value) {
        System.setProperty(key, value);
        System.out.printf("Set the system property [%s] to be %s.\n", key, value);
    }

    @Override
    public void removeSystemProperty(String key) {
        System.clearProperty(key);
        System.out.printf("Removes the system property [%s].\n", key);
    }

}
