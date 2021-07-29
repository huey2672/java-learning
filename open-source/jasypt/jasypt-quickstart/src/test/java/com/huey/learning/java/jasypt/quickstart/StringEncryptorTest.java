package com.huey.learning.java.jasypt.quickstart;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author huey
 */
public class StringEncryptorTest {

    private StringEncryptor stringEncryptor;

    @Before
    public void init() {

        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("password");
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");

        PooledPBEStringEncryptor pooledPBEStringEncryptor = new PooledPBEStringEncryptor();
        pooledPBEStringEncryptor.setConfig(config);
        stringEncryptor = pooledPBEStringEncryptor;

    }

    @Test
    public void testStringEncryptor() {

        // private data
        String privateData = "Password@1";

        // encrypt
        String encryptedText = stringEncryptor.encrypt(privateData);
        System.out.println("encryptedText = " + encryptedText);

        // decrypt
        String plainText = stringEncryptor.decrypt(encryptedText);
        System.out.println("plainText = " + plainText);

        Assert.assertEquals(plainText, privateData);

    }

}
