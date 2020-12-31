package com.huey.learning.java.collection.list.operationsummary;

import com.google.common.collect.Iterables;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author huey
 */
public class FindAnElementInListTest {

    private List<Customer> customers;

    @Before
    public void beforeTest() {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Tony"));
        customers.add(new Customer(2, "Huey"));
        customers.add(new Customer(3, "Jane"));
    }

    @Test
    public void testUsingEnhancedForLoop() {

        Customer huey = null;

        for (Customer customer : customers) {
            if ("Huey".equals(customer.getName())) {
                huey = customer;
                break;
            }
        }

        Assert.assertEquals(huey.getId(), Integer.valueOf(2));

    }

    @Test
    public void testUsingIterator() {

        Customer huey = null;

        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if ("Huey".equals(customer.getName())) {
                huey = customer;
                break;
            }
        }

        Assert.assertEquals(huey.getId(), Integer.valueOf(2));

    }

    @Test
    public void testUsingJava8StreamAPI() {

        Customer huey = customers.stream()
                .filter(customer -> "Huey".equals(customer.getName()))
                .findAny()
                .orElse(null);

        Assert.assertEquals(huey.getId(), Integer.valueOf(2));

    }

    @Test
    public void testUsingApacheCommonsIterableUtils() {

        Customer huey = IterableUtils.find(customers, customer -> "Huey".equals(customer.getName()));

        Assert.assertEquals(huey.getId(), Integer.valueOf(2));

    }

    @Test
    public void testUsingGuavaIterablesTryFind() {

        Customer huey = Iterables.tryFind(customers, customer -> "Huey".equals(customer.getName())).orNull();

        Assert.assertEquals(huey.getId(), Integer.valueOf(2));

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Customer {
        private Integer id;
        private String name;
    }

}
