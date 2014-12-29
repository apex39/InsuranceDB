package com.domain.model;

/**
 * Created by mateusz on 27.12.14.
 */
public class ZoneImpl implements Zone {
    private final int zoneId;

    public ZoneImpl(int zoneId) {
        this.zoneId = zoneId;
    }
    private float zoneRatio;

    public int getZoneId() {
        return zoneId;
    }

    public float getZoneRatio() {
        return zoneRatio;
    }

    public void setZoneRatio(float zoneRatio) {
        this.zoneRatio = zoneRatio;
    }
}
