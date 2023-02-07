package com.huey.learning.mapstruct.typeconversion;

public class CarDTO {
 
    private String make;
    private Integer seatCount;
    private String type;
    private String dateOfManufacture;

    public CarDTO() {
    }

    public CarDTO(String make, Integer seatCount, String type, String dateOfManufacture) {
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

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

}