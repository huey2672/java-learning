package com.github.javafaker;

/**
 * @author huey
 */
public class Dynasty {

    private final Faker faker;

    protected Dynasty(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("dynasty.name", this, this.faker);
    }

}
