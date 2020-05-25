package com.huey.learning.java.jaxb.xmladapter;

import org.junit.Test;

import javax.xml.bind.JAXB;
import java.util.Date;

/**
 * @author huey
 */
public class XmlJavaTypeAdapterTest {

    @Test
    public void testXmlJavaTypeAdapter() {

        Book book = new Book("9787508344980", "Head First Java", "2nd", new Date());

        JAXB.marshal(book, System.out);

    }

}
