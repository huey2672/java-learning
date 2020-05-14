package com.huey.hello.java.common.clone.deepcopy.copyconstructor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Book entity
 *
 * @author huey
 */
@Data
@AllArgsConstructor
public class Book {

    private String name;
    private String edition;
    private Person author;

    /**
     * copy constructor
     *
     * @param book
     */
    public Book(Book book) {
        this(book.getName(), book.getEdition(), new Person(book.getAuthor()));
    }

}