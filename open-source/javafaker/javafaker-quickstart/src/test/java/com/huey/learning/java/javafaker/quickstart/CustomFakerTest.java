package com.huey.learning.java.javafaker.quickstart;

import com.github.javafaker.CustomFaker;
import org.junit.Test;

/**
 * @author huey
 */
public class CustomFakerTest {

    CustomFaker faker = new CustomFaker();

    /**
     * 随机生成颜色
     */
    @Test
    public void testDynasty() {
        String color = faker.dynasty().name();
        System.out.println("Dynasty: " + color);
    }

}
