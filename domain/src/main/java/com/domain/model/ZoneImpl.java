package com.domain.model;

/**
 * Created by mateusz on 27.12.14.
 */
public class ZoneImpl implements Zone {
    private final int zoneId;
    private Type zoneType;
    private float zoneValue;

    public ZoneImpl(int zoneId) {
        this.zoneId = zoneId;
    }

    public void setZoneType(Type type) {
        this.zoneType = type;
    }

    public int getZoneId() {
        return zoneId;
    }

    public float getZoneValue() {
        return zoneValue;
    }

    public void setZoneValue(float zoneValue) {
        this.zoneValue = zoneValue;
    }
}
