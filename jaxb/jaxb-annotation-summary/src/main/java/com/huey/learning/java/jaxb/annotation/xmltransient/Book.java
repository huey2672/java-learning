package com.huey.learning.java.jaxb.annotation.xmltransient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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

    @XmlAttribute(name = "edition")
    private String edition;

    @XmlTransient
    private String brief;

}