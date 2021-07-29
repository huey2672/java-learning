package com.huey.learning.java.jasypt.springboot;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author huey
 */
@Configuration
@EncryptablePropertySource("encrypted.properties")
public class JasyptSample {

    @Value("${encrypted.property}")
    private String property;

    public String getProperty() {
        return property;
    }

}
