package com.huey.learning.java.jmx.quickstart;

/**
 * MBean interface, the name's format must be XxxMBean.
 *
 * @author huey
 */
public interface SystemPropertiesMBean {

    /**
     * Sets the system property
     *
     * @param key
     * @param value
     */
    void setSystemProperty(String key, String value);

    /**
     * Removes the system property
     *
     * @param key
     */
    void removeSystemProperty(String key);

}
