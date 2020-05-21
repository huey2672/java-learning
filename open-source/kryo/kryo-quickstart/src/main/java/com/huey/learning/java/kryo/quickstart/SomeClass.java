package com.huey.learning.java.kryo.quickstart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author huey
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SomeClass {

    private int intValue;
    private String stringValue;
    private Date dateValue;
    private byte[] arrayValue;

}
