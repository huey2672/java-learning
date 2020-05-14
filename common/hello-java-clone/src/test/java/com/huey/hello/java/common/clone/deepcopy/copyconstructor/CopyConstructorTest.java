package com.huey.hello.java.common.clone.deepcopy.copyconstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * an test class of copy constructor
 *
 * @author huey
 */
public class CopyConstructorTest {

    @Test
    public void testCopyConstructor() {

        Book book = new Book("Head First Java", "1 ed.", new Person("Eric", "Freeman"));

        Book bookCopy = new Book(book);
        bookCopy.setEdition("2 ed.");
        bookCopy.getAuthor().setFirstName("Elisabeth");

        Assert.assertNotEquals(book.getAuthor(), bookCopy.getAuthor());

    }

}
