package com.huey.learning.java.jvm.reference.type;

import org.junit.Assert;
import org.junit.Test;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huey
 */
public class SoftReferenceTest {

    /**
     * VM options: -Xms100M -Xmx100M
     */
    @Test
    public void testSoftReference() {

        // this code will create more than 100MB size
        List<SoftReference<TenMbObject>> softObjectList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            softObjectList.add(new SoftReference<>(new TenMbObject()));
        }

        // the first softly reachable object must be collected
        TenMbObject object = softObjectList.get(0).get();
        Assert.assertNull(object);

    }

}
