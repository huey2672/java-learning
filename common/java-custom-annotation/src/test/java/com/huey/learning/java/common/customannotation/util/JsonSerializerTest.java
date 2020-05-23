package com.huey.learning.java.common.customannotation.util;

import com.huey.learning.java.common.customannotation.entity.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huey
 */
public class JsonSerializerTest {

    @Test
    public void testSerialize() {

        Person person = new Person("mark", "huey", "34", "Beijing");
        JsonSerializer serializer = new JsonSerializer();
        String jsonString = serializer.serialize(person);

        Assert.assertEquals(jsonString, "{\"personAge\": \"34\", \"firstName\": \"Mark\", \"lastName\": \"Huey\"}");

    }

}
