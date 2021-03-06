package com.huey.learning.java.kryo.pitfall.missingnoargconstructor;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author huey
 */
public class MissingNoArgConstructorTest {

    // kryo instance
    private Kryo kryo;

    // the object to be serialized
    private Object sourceObject;

    @Before
    public void init() {

        kryo = new Kryo();

        // create source object
        sourceObject = new Student("Huey", 18);

    }

    @Test(expected = KryoException.class)
    public void testMissingNoArgConstructor() throws IOException {

        byte[] bytes = null;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, sourceObject);
            output.flush();
            bytes = baos.toByteArray();
        }

        try (InputStream abis = new ByteArrayInputStream(bytes);
             Input input = new Input(abis)) {
            kryo.readClassAndObject(input);
        }

    }

}
