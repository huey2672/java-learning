package com.huey.learning.java.jaxb.xmladapter;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String v) throws Exception {
        return DateUtils.parseDate(v, "yyyy-MM-dd");
    }

    @Override
    public String marshal(Date v) throws Exception {
        return DateFormatUtils.format(v, "yyyy-MM-dd");
    }
    
}