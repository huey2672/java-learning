package com.huey.learning.mapstruct.differentfieldnames;

public class Car {
 
    private String make;
    private Integer numberOfSeats;
    private String type;

    public Car() {
    }

    public Car(String make, Integer numberOfSeats, String type) {
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}