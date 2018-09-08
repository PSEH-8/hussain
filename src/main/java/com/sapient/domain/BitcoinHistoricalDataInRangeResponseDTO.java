package com.sapient.domain;

import java.util.List;

public class BitcoinHistoricalDataInRangeResponseDTO
{
    private List<DatePricePair> datePricePairs;


    public List<DatePricePair> getDatePricePairs() {
        return datePricePairs;
    }

    public void setDatePricePairs(List<DatePricePair> datePricePairs) {
        this.datePricePairs = datePricePairs;
    }
}
