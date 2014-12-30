package com.domain.model;



/**
 * Created by mateusz on 30.12.14.
 */
public class DiscountImpl implements Discount {
    private String name;
    private float value;
    private Type type;

    public DiscountImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
