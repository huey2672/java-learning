package com.huey.learning.mapstruct.differentfieldnames;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "seatCount", source = "numberOfSeats")
    CarDTO toDTO(Car car);

}