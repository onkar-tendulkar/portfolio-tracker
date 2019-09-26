package com.onkar.fetcher.price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class PriceFetcherAlphavantage implements PriceFetcher
{

    @Value("${alphavantage.price.url.part1}")
    private String urlPart1;
    @Value("${alphavantage.price.url.part2}")
    private String urlPart2;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public double getSecurityPrice(String symbol)
    {

        String completeURL = urlPart1+symbol+urlPart2;

        try
        {
            URL url = new URL(completeURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

        } catch (MalformedURLException e)
        {
            logger.error("Invalid URL : "+completeURL);
            throw new RuntimeException("Invalid URL : "+completeURL);
        } catch (IOException e)
        {
            logger.error("Could not open connection to URL : "+completeURL);
            throw new RuntimeException("Could not open connection to URL : "+completeURL);
        }



        /*
        try {
            url = new URL("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol="+symbol+"&apikey=6K10YYLMB43Y4RF5");


            HttpURLConnection conn = null;

            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");



            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }*/
        return 0;
    }
}
