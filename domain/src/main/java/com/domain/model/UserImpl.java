package com.domain.model;

/**
 * Created by mateusz on 27.12.14.
 */
public class UserImpl implements User {
    private String name;
    private String surname;
    private String id;

    public UserImpl(String id) {
        this.id = id;
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

    public String getId() {
        return id;
    }
}
