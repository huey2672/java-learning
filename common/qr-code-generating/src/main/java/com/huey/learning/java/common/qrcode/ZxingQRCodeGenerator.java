package com.huey.learning.java.common.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;

/**
 * a QR code generator based on Zxing
 *
 * @author huey
 */
public class ZxingQRCodeGenerator extends QRCodeGenerator {

    @Override
    public BufferedImage generateQRCodeImage(String qrcodeText) throws Exception {
        QRCodeWriter qrcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrcodeWriter.encode(qrcodeText, BarcodeFormat.QR_CODE, defaultWidth, defaultHeight);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

}