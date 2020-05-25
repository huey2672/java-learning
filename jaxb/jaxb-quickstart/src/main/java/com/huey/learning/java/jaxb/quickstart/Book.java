package com.huey.learning.java.jaxb.quickstart;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Book")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Book {

    @XmlElement(name = "ISBN")
    private String isbn;

    @XmlElement(name = "Title")
    private String title;

    @XmlElementWrapper(name = "AuthorList")
    @XmlElement(name = "Author")
    private List<Person> authorList;

}