package com.example.spring_data_intro.enums;

public enum AgeRestriction {
    MINOR("MINOR"),
    TEEN("TEEN"),
    ADULT("ADULT");

    private final String value;

    AgeRestriction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
