package com.huey.learning.java.jaxb.quickstart;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "Book")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @XmlElement(name = "ISBN")
    private String isbn;

    @XmlElement(name = "Title")
    private String title;

    @XmlElementWrapper(name = "AuthorList")
    @XmlElement(name = "Author")
    private List<Person> authorList;

}