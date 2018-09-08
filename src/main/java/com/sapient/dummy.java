package com.sapient;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class dummy
{

    public static void main(String[] args) {
        String date1 = "2018-08-18";
    }
    public static void main123(String[] args) {
        //Object oj = rt.getForObject("https://api.coindesk.com/v1/bpi/historical/close,json",Object.class);

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("https://api.coindesk.com/v1/bpi/historical/close.json");
        Invocation.Builder builder = webTarget.request();

        Response response = builder.get();
        String jsonString = response.readEntity(String.class);
        System.out.println("===>>>"+jsonString);

        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(jsonString);
            JSONObject jobj = (JSONObject) json.get("bpi");

            Map<String,String> map = new HashMap<>();
            Set<String> keySet = jobj.keySet();
            for(String str : keySet) {
                Double temp = (Double) jobj.get(str);
                map.put(str,temp.toString());
            }
            System.out.println(jobj.toJSONString());


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
