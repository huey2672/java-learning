package com.huey.learning.java.kryo.pitfall.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;
    private String street;

}
