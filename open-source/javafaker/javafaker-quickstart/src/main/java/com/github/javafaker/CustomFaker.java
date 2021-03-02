package com.github.javafaker;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;
import java.util.Random;

/**
 * @author huey
 */
public class CustomFaker extends Faker {

    private final Dynasty dynasty;

    public CustomFaker() {
        this(Locale.CHINA);
    }

    public CustomFaker(Locale locale) {
        this(locale, (Random)null);
    }

    public CustomFaker(Random random) {
        this(Locale.CHINA, random);
    }

    public CustomFaker(Locale locale, Random random) {
        this(locale, new RandomService(random));
    }

    public CustomFaker(Locale locale, RandomService randomService) {
        this(new FakeValuesService(locale, randomService), randomService);
    }

    public CustomFaker(FakeValuesService fakeValuesService, RandomService random) {
        super(fakeValuesService, random);
        this.dynasty = new Dynasty(this);
    }

    public Dynasty dynasty() {
        return dynasty;
    }

}
