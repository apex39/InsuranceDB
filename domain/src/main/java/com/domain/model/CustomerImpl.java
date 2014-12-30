package com.domain.model;

/**
 * Created by mateusz on 27.12.14.
 */
public class CustomerImpl implements Customer {
    private final String pesel;

    public CustomerImpl(String pesel) {
        this.pesel = pesel;
    }

    public String getPesel() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String name;
    private String surname;
    private String houseNumber;
    private String street;
    private String city;
}
