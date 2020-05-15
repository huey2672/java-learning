package com.huey.learning.java.collection.list;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

/**
 * unit test of CopyOnWriteArrayList
 *
 * @author huey
 */
public class CopyOnWriteArrayListTest {

    @Test
    public void testAddsElementsToCopyOnWriteArrayListDuringIteration() {

        // creates a copy-on-write list
        List<String> words = new CopyOnWriteArrayList<>(new String[]{"nice", "to", "meet", "you"});

        // gets the iterator of this list
        Iterator<String> iterator = words.iterator();

        // then adds an element to this list
        words.add("too");

        // iterates this list by the iterator and appends its elements to a new list
        List<String> words2 = new LinkedList<>();
        iterator.forEachRemaining(words2::add);

        // the element is added to the list truly
        assertThat(words, equalTo(Arrays.asList("nice", "to", "meet", "you", "too")));

        // but the new list is equal to the original list(before adding an element)
        assertThat(words2, equalTo(Arrays.asList("nice", "to", "meet", "you")));

    }

}
