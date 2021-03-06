package com.huey.learning.java.kryo.pitfall.cyclereference;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.huey.learning.java.kryo.pitfall.cglibproxyobject.Waiter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author huey
 */
public class CycleReferenceTest {

    // kryo instance
    private Kryo kryo;

    // the object to be serialized
    private Object sourceObject;

    @Before
    public void init() {

        kryo = new Kryo();

        // create source object
        Node first = new Node(1L);
        Node second = new Node(2L);
        first.setNext(second);
        second.setPrev(first);
        sourceObject = first;

    }

    @Test
    public void testReferenceTrue() throws IOException {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, sourceObject);
            output.flush();
            byte[] bytes = baos.toByteArray();
        }

    }

    @Test(expected = StackOverflowError.class)
    public void testReferenceFalse() throws IOException {

        kryo.setReferences(false);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, sourceObject);
            output.flush();
            byte[] bytes = baos.toByteArray();
        }

    }

}
