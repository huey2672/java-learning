package com.huey.learning.java.jaxb.annotation.xmlattribute;

import org.junit.Test;

import javax.xml.bind.JAXB;

/**
 * @author huey
 */
public class XmlAttributeTest {

    @Test
    public void testXmlAttribute() {

        Book book = new Book();
        book.setIsbn("9787508344980");
        book.setTitle("Head First Java");
        book.setEdition("2nd");

        JAXB.marshal(book, System.out);

    }

}
