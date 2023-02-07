package com.huey.learning.mapstruct.ignorefiled;

import com.huey.learning.mapstruct.defaultvalue.Car;
import com.huey.learning.mapstruct.defaultvalue.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "seatCount", ignore = true)
    CarDTO toDTO(Car car);

}