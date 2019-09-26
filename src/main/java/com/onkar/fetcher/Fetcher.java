package com.onkar.fetcher;


import com.onkar.fetcher.price.PriceFetcher;
import com.onkar.fetcher.universe.SecurityUniverseFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Fetcher
{
    @Autowired
    private SecurityUniverseFetcher securityListFetcher;

    @Autowired
    private PriceFetcher priceFetcher;

    @Scheduled(fixedRate = 60000)
    public void fetch()
    {
        List<String> list = securityListFetcher.getSecurityList();

        list.stream().forEach(s -> priceFetcher.getSecurityPrice(s));
    }
}
