package com.huey.learning.mapstruct.typeconversion;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "dateOfManufacture", dateFormat = "yyyy-MM-dd HH:mm:ss")
    CarDTO toDTO(Car car);

}