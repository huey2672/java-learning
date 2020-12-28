package com.huey.learning.java.collection.list.operationsummary;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

/**
 * @author huey
 */
public class RemovingAllNullsFromListTest {

    private List<Integer> list;

    @Before
    public void beforeTest() {
        list = new ArrayList<>(Arrays.asList(1, null, 2, null, 3));
    }

    @Test
    public void testUsingRemovingAll() {

        list.removeAll(Collections.singleton(null));

        assertThat(list, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingWhileLoop() {

        while (list.remove(null));

        assertThat(list, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingJava8LambdaAPI() {

        list.removeIf(Objects::isNull);

        assertThat(list, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingJava8StreamsAPI() {

        // parallelStream() or stream()
        List<Integer> listWithoutNulls = list.parallelStream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        assertThat(listWithoutNulls, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingApacheCommonsCollectionUtils() {

        CollectionUtils.filter(list, PredicateUtils.notNullPredicate());

        assertThat(list, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingGuavaIterablesRemoveIf() {

        Iterables.removeIf(list, Predicates.isNull());

        assertThat(list, containsInAnyOrder(1, 2, 3));

    }

    @Test
    public void testUsingGuavaIterablesFilter() {

        List<Integer> listWithoutNulls = Lists.newArrayList(Iterables.filter(list, Predicates.notNull()));

        assertThat(listWithoutNulls, containsInAnyOrder(1, 2, 3));

    }

}
