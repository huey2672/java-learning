package com.huey.learning.java.common.qrcode;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.charset.Charset;

@RestController
public class QRCodeController {

    @PostMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> qrcode(InputStream inputStream) throws Exception {
        String qrcodeText = IOUtils.toString(inputStream, Charset.forName("UTF-8"));
        QRCodeGenerator qrCodeGenerator = new ZxingQRCodeGenerator();
        BufferedImage qrcodeImage = qrCodeGenerator.generateQRCodeImage(qrcodeText);
        return ResponseEntity.ok(qrcodeImage);
    }

}