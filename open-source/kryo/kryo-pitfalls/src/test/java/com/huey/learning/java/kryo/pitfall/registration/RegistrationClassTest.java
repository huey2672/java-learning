package com.huey.learning.java.kryo.pitfall.registration;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.huey.learning.java.kryo.pitfall.anonymousinnerclass.IStudent;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huey
 */
public class RegistrationClassTest {

    // kryo instance
    private Kryo kryo;

    // the object to be serialized
    private Object sourceObject;

    @Before
    public void init() {

        kryo = new Kryo();
        kryo.setRegistrationRequired(true);

        // create source object
        List<Double> scores = new ArrayList<>();
        scores.add(95.0);
        scores.add(87.5);
        scores.add(99.0);
        Address address = new Address("Beijing", "ChangAnJie");
        Student student = new Student();
        student.setName("Huey");
        student.setScores(scores);
        student.setAddress(address);
        sourceObject = student;

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRegistration() throws IOException {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, sourceObject);
            output.flush();
            byte[] bytes = baos.toByteArray();
        }

    }

}
