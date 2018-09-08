package com.sapient.enums;

public enum Currency
{
    USD("USD"),
    INR("INR"),
    HKD("HKD"),
    SGP("SGP"),
    GBP("GBP");

    private String value ;

    public String getValue() {
        return value;
    }

    private Currency(String value) {
        this.value = value;
    }


}