package com.huey.learning.java.jaxb.quickstart;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * @author huey
 */
public class JaxbUtils {

    /**
     * convert a pojo to a xml string
     *
     * @param object
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> String marshal(T object) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    /**
     * converts a xml string to a pojo
     *
     * @param xml
     * @param objectClass
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> T unmarshal(String xml, Class<T> objectClass) throws JAXBException {
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        return unmarshal(inputStream, objectClass);
    }

    /**
     * converts an input stream to a pojo
     *
     * @param inputStream
     * @param objectClass
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> T unmarshal(InputStream inputStream, Class<T> objectClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(inputStream);
    }

}