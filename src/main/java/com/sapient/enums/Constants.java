package com.sapient.enums;

public enum Constants
{
    BITCOIN_HISTORICAL_DATA_URL("https://api.coindesk.com/v1/bpi/historical/close,json");

    private String value;

    public String getValue() {
        return value;
    }

    private Constants(String value) {
        this.value = value;
    }

}