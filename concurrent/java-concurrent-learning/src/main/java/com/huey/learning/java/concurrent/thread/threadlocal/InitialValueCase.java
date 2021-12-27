package com.huey.learning.java.concurrent.thread.threadlocal;

import java.util.Date;

/**
 * @author huey
 */
public class InitialValueCase {

    public static void main(String[] args) {

        ThreadLocal<Date> dateVar = new ThreadLocal<Date>() {
            @Override
            protected Date initialValue() {
                return new Date();
            }
        };

        System.out.println();
        System.out.println("dateVar = " + dateVar.get());
    }

}
