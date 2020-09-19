package com.huey.learning.java.jvm.gc.rc;

/**
 * @author huey
 */
public class CircularReferenceSample {

    CircularReferenceSample instance;

    public static void main(String[] args) {

        CircularReferenceSample obj1 = new CircularReferenceSample();
        CircularReferenceSample obj2 = new CircularReferenceSample();

        obj1.instance = obj2;
        obj2.instance = obj1;

        obj1 = null;
        obj2 = null;

        // Will obj1 and obj2 be collected?
        System.gc();

    }

}
