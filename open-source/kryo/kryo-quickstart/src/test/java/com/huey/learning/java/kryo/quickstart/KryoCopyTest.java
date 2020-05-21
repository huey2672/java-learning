package com.huey.learning.java.kryo.quickstart;

import com.esotericsoftware.kryo.Kryo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author huey
 */
public class KryoCopyTest {

    @Test
    public void testDeepCopy() {

        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);

        // creates an object
        int intValue = 1;
        String stringValue = "Kryo";
        Date dateValue = new Date();
        byte[] arrayValue = "Kryo".getBytes();
        SomeClass object1 = new SomeClass(intValue, stringValue, dateValue, arrayValue);

        SomeClass object2 = kryo.copy(object1);

        Assert.assertEquals(object1, object2);

        // modifies object1's field value.
        for (int i = 0; i < object1.getArrayValue().length; i++) {
            object1.getArrayValue()[i] = '$';
        }

        Assert.assertNotEquals(object1, object2);

    }

}
