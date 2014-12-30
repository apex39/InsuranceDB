package com.domain.model;

/**
 * Created by mateusz on 27.12.14.
 */
public class Car implements Vehicle {
    private final String registrationNumber;

    public Car(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    private String model;
    private String brand;
    private float capacity;
    private String vin;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        if(vin.length() == 17) {
            this.vin = vin;
        } else {
            throw new IllegalArgumentException("VIN length must equal 17");
        }
    }
}
