package com.huey.learning.java.jaxb.annotation.xmlattribute;

import org.junit.Test;

import javax.xml.bind.JAXB;

/**
 * @author huey
 */
public class XmlAttributeTest {

    @Test
    public void testXmlAttribute() {

        Book book = new Book("9787508344980", "Head First Java", "2nd");

        JAXB.marshal(book, System.out);

    }

}
