package com.huey.learning.java.common.qrcode;

import java.awt.image.BufferedImage;

/**
 * @author huey
 */
public abstract class QRCodeGenerator {

    protected int defaultWidth = 200;
    protected int defaultHeight = 200;

    public QRCodeGenerator() {
        super();
    }

    public QRCodeGenerator(int defaultWidth, int defaultHeight) {
        this.defaultWidth = defaultWidth;
        this.defaultHeight = defaultHeight;
    }

    public abstract BufferedImage generateQRCodeImage(String qrcodeText) throws Exception;

}
