package com.ucode.demohotelmanagement.model;

public enum OccupiedStatus {
    OCCUPIED("Occupied"),
    FREE("Free"),
    IN_RENOVATION("In Renovation");

    private String displayName;

    OccupiedStatus(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
