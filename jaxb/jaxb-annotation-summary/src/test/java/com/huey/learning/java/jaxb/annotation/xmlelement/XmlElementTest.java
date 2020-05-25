package com.huey.learning.java.jaxb.annotation.xmlelement;

import org.junit.Test;

import javax.xml.bind.JAXB;

/**
 * @author huey
 */
public class XmlElementTest {

    @Test
    public void testXmlElement() {

        Book book = new Book();
        book.setIsbn("9787508344980");
        book.setTitle("Head First Java");

        JAXB.marshal(book, System.out);

    }

}
