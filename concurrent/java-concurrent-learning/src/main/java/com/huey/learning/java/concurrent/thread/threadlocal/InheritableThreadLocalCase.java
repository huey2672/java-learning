package com.huey.learning.java.concurrent.thread.threadlocal;

import java.util.Date;

/**
 * @author huey
 */
public class InheritableThreadLocalCase {

    public static void main(String[] args) {

        ThreadLocal<Date> dateVar = new InheritableThreadLocal<Date>() {

            protected Date initialValue() {
                return new Date();
            }

            protected Date childValue(Date parentValue) {
                return new Date(parentValue.getTime() + 1000L);
            }

        };

    }

}
