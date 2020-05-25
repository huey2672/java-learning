package com.huey.learning.java.jaxb.quickstart;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huey
 */
public class JaxbUtilsTest {

    @Test
    public void testMarshal() throws Exception {

        List<Person> authorList = new ArrayList<>();
        authorList.add(new Person("Kathy", "Sierra"));
        authorList.add(new Person("Bert", "Bates"));
        Book book = new Book("9787508344980", "Head First Java", authorList);

        String xml = JaxbUtils.marshal(book);
        System.out.println(xml);

    }

    @Test
    public void testUnmarshal() throws Exception {

        InputStream inputStream = new FileInputStream("src/main/resources/book.xml");
        Book book = JaxbUtils.unmarshal(inputStream, Book.class);
        System.out.println(book);
        
    }

}
