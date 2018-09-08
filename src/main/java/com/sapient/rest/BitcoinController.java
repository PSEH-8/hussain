package com.sapient.rest;


import com.sapient.domain.BitcoinHistoricalDataInRangeResponseDTO;
import com.sapient.service.BitcoinHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
public class BitcoinController
{

    @Autowired
    private BitcoinHistoryService bitcoinHistoryService;

    @RequestMapping(value = "/bitcoin/historical",method = RequestMethod.GET,produces = "application/json")
    public BitcoinHistoricalDataInRangeResponseDTO retrieveDetailsForCourse(@QueryParam("startDate") String startDate,
                                           @QueryParam("endDate") String endDate) {

        BitcoinHistoricalDataInRangeResponseDTO bitcoinHistoricalDataInRangeResponseDTO = new BitcoinHistoricalDataInRangeResponseDTO();
        bitcoinHistoricalDataInRangeResponseDTO.setDatePricePairs(bitcoinHistoryService.fetchDatePricePairsWithinDateRange(startDate,endDate));

        return bitcoinHistoricalDataInRangeResponseDTO;
    }
}
