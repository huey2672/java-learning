package com.huey.learning.java.common.qrcode;

import net.glxn.qrgen.javase.QRCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * a QR code generator based on QRGen
 *
 * @author huey
 */
public class QRGenQRCodeGenerator extends QRCodeGenerator {

    @Override
    public BufferedImage generateQRCodeImage(String qrcodeText) throws Exception {
        ByteArrayOutputStream stream = QRCode.from(qrcodeText)
                .withSize(defaultWidth, defaultHeight)
                .stream();
        ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());
        return ImageIO.read(bis);
    }

}