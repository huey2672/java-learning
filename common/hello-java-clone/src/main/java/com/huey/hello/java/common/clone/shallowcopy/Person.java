package com.huey.hello.java.common.clone.shallowcopy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Person entity
 *
 * @author huey
 */
@Data
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
