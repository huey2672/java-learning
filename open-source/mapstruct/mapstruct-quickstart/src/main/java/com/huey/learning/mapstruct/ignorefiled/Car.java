package com.huey.learning.mapstruct.ignorefiled;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
 
    private String make;
    private Integer seatCount;
    private String type;
    private String uuid;

}