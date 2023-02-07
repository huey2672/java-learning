package com.huey.learning.mapstruct.typeconversion;

import java.util.Date;

public class Car {
 
    private String make;
    private Integer seatCount;
    private String type;
    private Date dateOfManufacture;

    public Car() {
    }

    public Car(String make, Integer seatCount, String type, Date dateOfManufacture) {
        this.make = make;
        this.seatCount = seatCount;
        this.type = type;
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
}