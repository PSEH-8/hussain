package com.sapient.service;

import com.sapient.config.BitcoinHistoryDataMap;
import com.sapient.domain.DatePricePair;
import com.sapient.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BitcoinHistoryService {
    @Autowired
    private BitcoinHistoryDataMap bitcoinHistoryDataMap;

    public List<DatePricePair> fetchDatePricePairsWithinDateRange(String startDate, String endDate) {


        List<DatePricePair> datePricePairList = new ArrayList<>();
        for (Map.Entry<String, String> entry : bitcoinHistoryDataMap.getBitcoinHistoryDataMap().entrySet()) {
            /*System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());*/
            try {
                Date key = BaseUtil.stringToDateConversion(entry.getKey());
                Double price = BaseUtil.stringToPriceInDoubleConversion(entry.getValue());

                if(key.compareTo(BaseUtil.stringToDateConversion(startDate))  > 0  && key.compareTo(BaseUtil.stringToDateConversion(endDate))<0)
                {
                    datePricePairList.add(new DatePricePair(key,price));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
