package com.huey.learning.java.jaxb.annotation.xmlelementwrapper;

import org.junit.Test;

import javax.xml.bind.JAXB;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huey
 */
public class XmlElementWrapperTest {

    @Test
    public void testXmlElementWrapper() {

        List<Person> authorList = new ArrayList<>();
        authorList.add(new Person("Kathy", "Sierra"));
        authorList.add(new Person("Bert", "Bates"));
        Book book = new Book("9787508344980", "Head First Java", "2nd", "Balabala...", authorList);

        JAXB.marshal(book, System.out);

    }

}
