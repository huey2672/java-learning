package com.huey.learning.java.jasypt.springboot;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EncryptablePropertySource("jdbc-encrypted.properties")
public class JasyptWithSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasyptWithSpringbootApplication.class, args);
    }

}
