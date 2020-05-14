package com.huey.hello.java.common.clone.shallowcopy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Book entity
 *
 * @author huey
 */
@Data
@AllArgsConstructor
public class Book implements Cloneable {

    private String name;
    private String edition;
    private Person author;

    /**
     * clones an object by implementing the Cloneable interface
     */
    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
