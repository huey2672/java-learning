package com.huey.learning.java.jaxb.annotation.xmlattribute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author huey
 */
@XmlRootElement(name = "Book")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.Data
public class Book {

    @XmlElement(name = "ISBN")
    private String isbn;

    @XmlElement(name = "Title")
    private String title;

    @XmlAttribute(name = "edition")
    private String edition;

}