package com.huey.learning.java.jaxb.annotation.xmltransient;

import org.junit.Test;

import javax.xml.bind.JAXB;

/**
 * @author huey
 */
public class XmlTransientTest {

    @Test
    public void testXmlTransient() {

        Book book = new Book();
        book.setIsbn("9787508344980");
        book.setTitle("Head First Java");
        book.setEdition("2nd");
        book.setBrief("Balabala...");

        JAXB.marshal(book, System.out);

    }

}
