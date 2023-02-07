package com.huey.learning.mapstruct.defaultvalue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private String make;
    private Integer seatCount;
    private String type;
    private String uuid;

}