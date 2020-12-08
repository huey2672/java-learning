package com.huey.learning.java.shiro.cryptography;

import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * @author huey
 */
public class Sha256HashSample {

    public static void main(String[] args) {
        Sha256Hash hash = new Sha256Hash("password", "shiro");
        System.out.println(hash.toString());
    }

}
