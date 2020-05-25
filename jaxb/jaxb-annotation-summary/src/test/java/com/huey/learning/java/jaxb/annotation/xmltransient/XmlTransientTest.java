package com.huey.learning.java.jaxb.annotation.xmltransient;

import org.junit.Test;

import javax.xml.bind.JAXB;

/**
 * @author huey
 */
public class XmlTransientTest {

    @Test
    public void testXmlTransient() {

        Book book = new Book("9787508344980", "Head First Java", "2nd", "Balabala...");

        JAXB.marshal(book, System.out);

    }

}
