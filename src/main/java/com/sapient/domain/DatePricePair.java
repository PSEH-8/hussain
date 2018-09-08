package com.sapient.domain;

import java.util.Date;

public class DatePricePair
{
    private Date date ;
    private Double price;

    public DatePricePair(Date date, Double price) {
        this.date = date ;
        this.price = price;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
