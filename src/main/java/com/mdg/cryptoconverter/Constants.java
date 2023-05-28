package com.mdg.cryptoconverter;

public enum Constants {
    STAGE_TITLE("Crypto Converter"),
    COPIED("Copied");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
