package com.huey.learning.java.kryo.quickstart;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * a case of KryoSerializer, test serialization and deserialization
 *
 * @author huey
 */
public class KryoSerializerTest {

    @Test
    public void testKryoSerializer() {

        // creates an object
        int intValue = 1;
        String stringValue = "Kryo";
        Date dateValue = new Date();
        byte[] arrayValue = "Kryo".getBytes();
        SomeClass object = new SomeClass(intValue, stringValue, dateValue, arrayValue);

        byte[] objectBytes = KryoSerializer.serialize(object);

        SomeClass object2 = KryoSerializer.deserialize(objectBytes, SomeClass.class);

        Assert.assertEquals(object, object2);

    }

}
