package com.huey.learning.mapstruct.simple;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO toDTO(Car car);

}