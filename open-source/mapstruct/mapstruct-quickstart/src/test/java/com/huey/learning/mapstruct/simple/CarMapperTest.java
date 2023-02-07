package com.huey.learning.mapstruct.simple;

import org.junit.Test;

public class CarMapperTest {

    @Test
    public void shouldMapCarToDto() {

        Car car = new Car("Morris", 5, "SEDAN");

        CarDTO carDTO = CarMapper.INSTANCE.toDTO(car);

    }

}
