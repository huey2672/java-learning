package com.huey.learning.mapstruct.differentfieldnames;

import org.junit.Test;

public class CarMapperTest {

    @Test
    public void shouldMapCarToDto() {

        Car car = new Car("Morris", 5, "SEDAN");

        CarDTO carDto = CarMapper.INSTANCE.toDTO(car);

        System.out.println("carDto = " + carDto);

    }

}
