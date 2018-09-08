package com.sapient.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BaseUtil
{
    public static Date stringToDateConversion(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("DD-MM-YYYY", Locale.ENGLISH);
        Date convertedDate = format.parse(date);
        //System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010

        return convertedDate;
    }


    public static Double stringToPriceInDoubleConversion(String price) {

        return Double.parseDouble(price);
    }
}
