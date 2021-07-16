package com.huey.learning.java.kryo.pitfall.cglibproxyobject;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author huey
 */
public class CglibProxyObjectTest {

    // kryo instance
    private Kryo kryo;

    // the object to be serialized
    private Object sourceObject;

    @Before
    public void init() {

        kryo = new Kryo();

        // create source object
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("cglibproxyobject/spring.xml");
        sourceObject = appCtx.getBean(Waiter.class);

    }

    @Test(expected = KryoException.class)
    public void testCglibProxyObject() throws IOException {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, sourceObject);
            output.flush();
            byte[] bytes = baos.toByteArray();
        }

    }

}
