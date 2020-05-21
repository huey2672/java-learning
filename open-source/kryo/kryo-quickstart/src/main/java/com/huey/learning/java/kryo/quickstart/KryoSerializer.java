package com.huey.learning.java.kryo.quickstart;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * a serializer based on Kryo
 *
 * @author huey
 */
public final class KryoSerializer {

    private KryoSerializer() {
        super();
    }

    /**
     * serialization, writes an object to an byte array
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> byte[] serialize(T object) {

        byte[] bytes = null;

        if (object == null) {
            return bytes;
        }

        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {

            kryo.writeObject(output, object);
            output.flush();
            bytes = baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    /**
     * deserialization, reads an object from an byte array
     *
     * @param bytes
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] bytes, Class<T> type) {
        T object = null;

        if (bytes == null) {
            return null;
        }

        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);

        try (InputStream abis = new ByteArrayInputStream(bytes);
             Input input = new Input(abis)) {

            object = kryo.readObject(input, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }

}
