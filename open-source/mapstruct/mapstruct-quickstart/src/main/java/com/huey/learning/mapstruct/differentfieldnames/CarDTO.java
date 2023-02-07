package com.huey.learning.mapstruct.differentfieldnames;

public class CarDTO {
 
    private String make;
    private Integer seatCount;
    private String type;

    public CarDTO() {
    }

    public CarDTO(String make, Integer seatCount, String type) {
        this.make = make;
        this.seatCount = seatCount;
        this.type = type;
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

}