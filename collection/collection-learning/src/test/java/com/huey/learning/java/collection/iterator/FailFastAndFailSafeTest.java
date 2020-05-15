package com.huey.learning.java.collection.iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

/**
 * test case of fail-fast iterator and fail-safe iterator
 *
 * @author huey
 */
public class FailFastAndFailSafeTest {

    @Test(expected = ConcurrentModificationException.class)
    public void testFailFast() {

        // creates a array list
        List<String> words = new ArrayList<String>(Arrays.asList("nice", "to", "meet", "you"));

        // gets the iterator of this list
        Iterator<String> iterator = words.iterator();

        // iterates this list by the iterator
        while (iterator.hasNext()) {
            String word = iterator.next();
            System.out.println(word);

            // it will throws an exception if we modify the list during iteration
            words.add("too");
        }

    }

    @Test
    public void testFailSafe() {

        // creates a copy-on-write list
        List<String> words = new CopyOnWriteArrayList<>(new String[]{"Nice", "to", "meet", "you"});

        // gets the iterator of this list
        Iterator<String> iterator = words.iterator();

        // then adds an element to this list
        words.add("too");

        // iterates this list by the iterator and appends its elements to a new list
        List<String> words2 = new LinkedList<>();
        iterator.forEachRemaining(words2::add);

        // the element is added to the list truly
        assertThat(words, equalTo(Arrays.asList("Nice", "to", "meet", "you", "too")));

        // but the new list is equal to the original list(before adding an element)
        assertThat(words2, equalTo(Arrays.asList("Nice", "to", "meet", "you")));

    }

}
