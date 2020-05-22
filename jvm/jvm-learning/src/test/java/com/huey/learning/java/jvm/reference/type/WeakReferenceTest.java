package com.huey.learning.java.jvm.reference.type;

import org.junit.Assert;
import org.junit.Test;

import java.lang.ref.WeakReference;

/**
 * @author huey
 */
public class WeakReferenceTest {

    @Test
    public void testWeakReference() {

        WeakReference<Object> weakObject = new WeakReference<>(new Object());

        Assert.assertNotNull(weakObject.get());

        // runs the garbage collector
        System.gc();

        //
        Assert.assertNull(weakObject.get());

    }

}
