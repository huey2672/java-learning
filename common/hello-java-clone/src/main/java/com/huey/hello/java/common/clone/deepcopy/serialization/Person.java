package com.huey.hello.java.common.clone.deepcopy.serialization;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Person entity
 *
 * @author huey
 */
@Data
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
