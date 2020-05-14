package com.huey.learning.java.common.clone.deepcopy.serialization;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

/**
 * an test class of serialization(Gson) copy
 *
 * @author huey
 */
public class GsonSerializationTest {

    @Test
    public void testGsonSerialization() {

        Book book = new Book("Head First Java", "1 ed.", new Person("Eric", "Freeman"));

        Gson gson = new Gson();
        Book bookCopy = gson.fromJson(gson.toJson(book), Book.class);
        bookCopy.setEdition("2 ed.");
        bookCopy.getAuthor().setFirstName("Elisabeth");

        Assert.assertNotEquals(book.getAuthor(), bookCopy.getAuthor());

    }

}
