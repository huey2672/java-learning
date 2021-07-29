package com.huey.learning.java.jasypt.quickstart;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author huey
 */
@RunWith(Parameterized.class)
public class PasswordEncryptorTest {

    private static final String USER_PASSWORD = "password";

    private boolean expected;
    private String inputPassword;

    @Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[]{true, "password"},
                new Object[]{false, "PASSWORD"});
    }

    public PasswordEncryptorTest(boolean expected, String inputPassword) {
        this.expected = expected;
        this.inputPassword = inputPassword;
    }

    @Test
    public void testPasswordEncryptor() {

        PasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(USER_PASSWORD);

        boolean matched = passwordEncryptor.checkPassword(inputPassword, encryptedPassword);

        Assert.assertEquals(expected, matched);

    }

}
