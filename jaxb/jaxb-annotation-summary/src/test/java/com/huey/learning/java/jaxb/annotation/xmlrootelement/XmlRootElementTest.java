package com.huey.learning.java.jaxb.annotation.xmlrootelement;

import org.junit.Test;

import javax.xml.bind.JAXB;

/**
 * @author huey
 */
public class XmlRootElementTest {

    @Test
    public void testXmlRootElement() {

        Book book = new Book();

        JAXB.marshal(book, System.out);

    }

}
