package com.huey.learning.java.common.customannotation.util;

import com.huey.learning.java.common.customannotation.annotation.Init;
import com.huey.learning.java.common.customannotation.annotation.JsonElement;
import com.huey.learning.java.common.customannotation.annotation.JsonSerializable;
import com.huey.learning.java.common.customannotation.exception.JsonSerializationException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * a json serializer
 *
 * @author huey
 */
public class JsonSerializer {

    /**
     * @param object
     * @param <T>
     * @return
     * @throws JsonSerializationException
     */
    public <T> String serialize(T object) throws JsonSerializationException {

        try {
            checkIfSerializable(object);
            T clone = cloneAndInitObject(object);
            return getJsonString(clone);
        } catch (Exception e) {
            throw new JsonSerializationException(e.getMessage());
        }

    }

    /**
     * checks whether an object is null or not,
     * as well as whether its type has the @JsonSerializable annotation or not
     *
     * @param object
     * @param <T>
     */
    private <T> void checkIfSerializable(T object) {

        if (Objects.isNull(object)) {
            throw new JsonSerializationException("The object to serialize is null.");
        }

        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new JsonSerializationException(
                    "The class " + clazz.getSimpleName() + " is not annotated with @JsonSerializable.");
        }

    }

    /**
     * clones an object and initializes the clone
     *
     * @param object
     * @param <T>
     * @throws Exception
     */
    private <T> T cloneAndInitObject(T object) throws Exception {

        T clone = this.clone(object);

        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(clone);
            }
        }

        return clone;

    }

    /**
     * clones an object
     *
     * @param object
     * @param <T>
     * @return
     * @throws Exception
     */
    private <T> T clone(T object) throws Exception {

        Class<?> clazz = object.getClass();

        T clone = (T) clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            field.set(clone, field.get(object));
        }

        return clone;
    }

    /**
     * @param object
     * @param <T>
     * @return
     * @throws Exception
     */
    private <T> String getJsonString(T object) throws Exception {

        // stores key-value pairs in a hash map
        Map<String, String> jsonElementsMap = new HashMap<>();

        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonElement.class)) {
                field.setAccessible(true);
                jsonElementsMap.put(getKey(field), (String) field.get(object));
            }
        }

        // concatenates the map's elements
        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\": \"" + entry.getValue() + "\"")
                .collect(Collectors.joining(", "));

        return "{" + jsonString + "}";

    }

    /**
     * gets a field's key
     *
     * @param field
     * @return
     */
    private String getKey(Field field) {

        JsonElement jsonElement = field.getAnnotation(JsonElement.class);
        String key = jsonElement.key();

        if (key.isEmpty()) {
            key = field.getName();
        }

        return key;

    }

}