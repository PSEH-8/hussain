package com.sapient.config;

import com.sapient.enums.Constants;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleToLongFunction;

@Component
public class BitcoinHistoryDataMap
{
    public static Map<String,String> bitcoinHistoryDataMap ;
    public static Map<Date, Double> bitcoinHistoryDataMap2 ;

    @PostConstruct
    void init()
    {
        bitcoinHistoryDataMap = new HashMap<>();

        Client client = ClientBuilder.newClient();
        //WebTarget webTarget = client.target("https://api.coindesk.com/v1/bpi/historical/close.json");
        WebTarget webTarget = client.target(Constants.BITCOIN_HISTORICAL_DATA_URL.getValue());
        Invocation.Builder builder = webTarget.request();

        Response response = builder.get();
        String jsonString = response.readEntity(String.class);
        //System.out.println("===>>>"+jsonString);

        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(jsonString);
            JSONObject jobj = (JSONObject) json.get("bpi");

            //Map<String,String> map = new HashMap<>();
            Set<String> keySet = jobj.keySet();
            for(String key : keySet) {
                Double temp = (Double) jobj.get(key);
                bitcoinHistoryDataMap.put(key,temp.toString());
            }
            //System.out.println(jobj.toJSONString());


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Map<String,String> getBitcoinHistoryDataMap()
    {
        return bitcoinHistoryDataMap;
    }

}
