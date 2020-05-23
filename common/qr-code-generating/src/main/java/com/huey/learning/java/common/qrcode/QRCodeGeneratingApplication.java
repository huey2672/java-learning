package com.huey.learning.java.common.qrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

/**
 * @author huey
 */
@SpringBootApplication
public class QRCodeGeneratingApplication {

    public static void main(String[] args) {
        SpringApplication.run(QRCodeGeneratingApplication.class, args);
    }

    /**
     * adds a HttpMessageConverter for BufferedImage
     *
     * @return
     */
    @Bean
    public HttpMessageConverter<BufferedImage> bufferedImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

}
