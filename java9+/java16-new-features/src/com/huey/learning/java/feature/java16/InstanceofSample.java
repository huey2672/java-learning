package com.huey.learning.java.feature.java16;

public class InstanceofSample {

    public void sampleBeforeJava14(Object param) {

        if (param instanceof String) {
            String str = (String) param;
            // do something with str
        }

    }

    public void sampleInJava14(Object param) {

        if (param instanceof String str) {
            // do something with str
        }

    }

}
