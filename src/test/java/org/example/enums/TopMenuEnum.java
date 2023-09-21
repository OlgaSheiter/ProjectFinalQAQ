package org.example.enums;

public enum TopMenuEnum {
    Summary("Summary"),
    Grid("Grid"),
    Histogram("Histogram"),
    Scatter("Scatter-plot"),
    Reports("Reports");

    private String value;

    TopMenuEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
