package com.huey.learning.java.javafaker.quickstart;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Date;
import java.util.Locale;

/**
 * @author huey
 */
public class FakerTest {

    Faker faker = new Faker(Locale.CHINA);

    /**
     * 随机生成地址数据
     */
    @Test
    public void testAddress() {
        String city = faker.address().city();
        System.out.println("City: " + city);
        String longitude = faker.address().longitude();
        String latitude = faker.address().latitude();
        System.out.println("Geographic location: " + longitude + ", " + latitude);
    }

    /**
     * 随机生成书籍数据
     */
    @Test
    public void testBook() {
        String title = faker.book().title();
        String author = faker.book().author();
        String publisher = faker.book().publisher();
        String genre = faker.book().genre();
        System.out.println("Book: " + title + " - " + author + " - " + publisher + " - " + genre);
    }

    /**
     * 随机生成颜色
     */
    @Test
    public void testColor() {
        String color = faker.color().name();
        System.out.println("Color: " + color);
    }

    /**
     * 随机生成日期
     */
    @Test
    public void testDateAndTime() {
        Date dateBetween20210101And20211231 = faker.date().between(new Date(1609430400000L), new Date(1640966399999L));
        System.out.println("Date Between 20210101 And 20211231: " + dateBetween20210101And20211231);
    }

    /**
     * 随机生成名字
     */
    @Test
    public void testName() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = faker.name().fullName();
        System.out.println("firstName: " + firstName + ", lastName: " + lastName + ", fullName: " + fullName);
    }

    /**
     * 随机生成数字
     */
    @Test
    public void testNumber() {
        int intNumber = faker.number().numberBetween(10, 100);
        long longNumber = faker.number().numberBetween(10L, 100L);
    }

}
