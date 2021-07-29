package com.huey.learning.java.jasypt.springboot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huey
 */
@SpringBootTest
public class JasyptSampleTest {

    @Autowired
    private JasyptSample jasyptSample;

    @Test
    void testEncryptedProperty() {

        String property = jasyptSample.getProperty();
        System.out.println("property = " + property);

        assertThat(property, equalTo("Password@1"));

    }

}
