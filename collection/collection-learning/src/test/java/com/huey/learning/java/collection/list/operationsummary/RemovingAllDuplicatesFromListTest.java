package com.huey.learning.java.collection.list.operationsummary;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

/**
 * @author huey
 */
public class RemovingAllDuplicatesFromListTest {

    private List<Integer> list;

    @Before
    public void beforeTest() {
        list = new ArrayList<>(Arrays.asList(1, 2, 2, 1, 3));
    }


    @Test
    public void testUsingSet() {

        List<Integer> listWithoutDuplicates = new ArrayList<>(new HashSet<>(list));

        assertThat(listWithoutDuplicates, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingJava8StreamsAPI() {

        List<Integer> listWithoutDuplicates = list.stream()
                .distinct()
                .collect(Collectors.toList());

        assertThat(listWithoutDuplicates, containsInAnyOrder(1, 2, 3));

    }

}
