package com.huey.learning.java.common.clone.deepcopy.serialization;

import com.esotericsoftware.kryo.Kryo;
import org.junit.Assert;
import org.junit.Test;

/**
 * a test class of kryo copy
 *
 * @author huey
 */
public class KryoCopyTest {

    @Test
    public void testKryoCopy() {

        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);

        Book book = new Book("Head First Java", "1 ed.", new Person("Eric", "Freeman"));

        Book bookCopy = kryo.copy(book);
        bookCopy.setEdition("2 ed.");
        bookCopy.getAuthor().setFirstName("Elisabeth");

        Assert.assertNotEquals(book.getAuthor(), bookCopy.getAuthor());

    }

}
