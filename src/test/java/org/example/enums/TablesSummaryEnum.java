package org.example.enums;

public enum TablesSummaryEnum {
    AlgoPerformance("Algo Performance"),
    OrdersByInsrtrumentAlgo("Orders by instrument / algo (top 10)");

    private String value;

    TablesSummaryEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
