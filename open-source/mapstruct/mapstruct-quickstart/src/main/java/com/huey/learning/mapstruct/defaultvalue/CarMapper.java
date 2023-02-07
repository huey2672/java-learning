package com.huey.learning.mapstruct.defaultvalue;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "type", source = "type", defaultValue = "SEDAN")
    @Mapping(target = "uuid", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    CarDTO toDTO(Car car);

}