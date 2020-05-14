package com.huey.hello.java.common.clone.deepcopy.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * an utility class of serialization
 *
 * @author huey
 */
public class SerializationUtils {

    /**
     * clones an object by serialization (deeply)
     *
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(final T object) {

        // writes object to an ByteArrayOutputStream
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(bout)) {
            output.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException("IOException while writing object data", e);
        }

        // reads object from the ByteArrayOutputStream
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        try (ObjectInputStream input = new ObjectInputStream(bin)) {
            return (T) input.readObject();
        } catch (Exception e) {
            throw new RuntimeException("IOException while reading object data", e);
        }

    }

}
