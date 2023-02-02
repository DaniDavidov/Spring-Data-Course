package com.example.spring_data_intro.enums;

public enum EditionType {
    NORMAL("NORMAL"),
    PROMO("PROMO"),
    GOLD("GOLD");

    private final String value;

    EditionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
