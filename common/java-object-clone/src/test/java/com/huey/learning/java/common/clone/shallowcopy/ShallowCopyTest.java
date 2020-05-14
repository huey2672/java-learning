package com.huey.learning.java.common.clone.shallowcopy;

import org.junit.Assert;
import org.junit.Test;

/**
 * an test class of shallow copy
 *
 * @author huey
 */
public class ShallowCopyTest {

    @Test
    public void testShallowCopy() {

        Book book = new Book("Head First Design Pattern", "1 ed.", new Person("Eric", "Freeman"));

        Book bookCopy = book.clone();
        bookCopy.setEdition("2 ed.");
        bookCopy.getAuthor().setFirstName("Elisabeth");

        // Note: the book's author is also modified
        Assert.assertEquals(book.getAuthor(), bookCopy.getAuthor());

    }

}
