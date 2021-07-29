package com.huey.learning.java.jasypt.quickstart;

import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.TextEncryptor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author huey
 */
public class TextEncryptorTest {

    private TextEncryptor textEncryptor;

    @Before
    public void init() {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPasswordCharArray("password".toCharArray());
        textEncryptor = basicTextEncryptor;
    }

    @Test
    public void testTextEncryptor() {

        // private data
        String privateData = "Password@1";

        // encrypt
        String encryptedText = textEncryptor.encrypt(privateData);
        System.out.println("encryptedText = " + encryptedText);

        // decrypt
        String plainText = textEncryptor.decrypt(encryptedText);
        System.out.println("plainText = " + plainText);

        Assert.assertEquals(plainText, privateData);

    }

}
