package com.huey.learning.java.jvm.reference.type;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huey
 */
public class StrongReferenceTest {

    /**
     * VM options: -Xms100M -Xmx100M
     */
    @Test(expected = OutOfMemoryError.class)
    public void testOOM() {

        List<TenMbObject> objectList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            objectList.add(new TenMbObject());
        }

    }

}
