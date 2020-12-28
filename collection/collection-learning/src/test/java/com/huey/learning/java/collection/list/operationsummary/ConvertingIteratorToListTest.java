package com.huey.learning.java.collection.list.operationsummary;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.IteratorUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

/**
 * @author huey
 */
public class ConvertingIteratorToListTest {

    private Iterator<Integer> iterator;

    @Before
    public void beforeTest() {
        iterator = Arrays.asList(1, 2, 3).iterator();
    }

    @Test
    public void testUsingWhileLoop() {

        List<Integer> actualList = new ArrayList<>();
        while (iterator.hasNext()) {
            actualList.add(iterator.next());
        }

        assertThat(actualList, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingJava8IteratorForEachRemaining() {

        List<Integer> actualList = new ArrayList<Integer>();
        iterator.forEachRemaining(actualList::add);

        assertThat(actualList, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingJava8StreamsAPI() {

        Iterable<Integer> iterable = () -> iterator;
        List<Integer> actualList = StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        assertThat(actualList, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingApacheCommonsIteratorUtils() {

        List<Integer> actualList = IteratorUtils.toList(iterator);

        assertThat(actualList, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingGuavaImmutableList() {

        List<Integer> actualList = ImmutableList.copyOf(iterator);

        assertThat(actualList, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingGuavaLists() {

        List<Integer> actualList = Lists.newArrayList(iterator);

        assertThat(actualList, containsInAnyOrder(1, 2, 3));

    }

}
