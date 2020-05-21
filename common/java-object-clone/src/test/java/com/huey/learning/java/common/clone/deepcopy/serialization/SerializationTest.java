package com.huey.learning.java.common.clone.deepcopy.serialization;

import org.junit.Assert;
import org.junit.Test;

/**
 * a test class of serialization copy
 *
 * @author huey
 */
public class SerializationTest {

    @Test
    public void testSerialization() {

        Book book = new Book("Head First Java", "1 ed.", new Person("Eric", "Freeman"));

        Book bookCopy = SerializationUtils.clone(book);
        bookCopy.setEdition("2 ed.");
        bookCopy.getAuthor().setFirstName("Elisabeth");

        Assert.assertNotEquals(book.getAuthor(), bookCopy.getAuthor());

    }

}
