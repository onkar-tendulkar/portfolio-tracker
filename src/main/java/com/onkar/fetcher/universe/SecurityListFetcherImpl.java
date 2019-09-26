package com.onkar.fetcher.universe;

import com.onkar.domain.Security;
import com.onkar.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SecurityListFetcherImpl implements SecurityUniverseFetcher
{

    @Autowired
    SecurityRepository repo;

    public List<String> getSecurityList()
    {
        List<Security> securities = repo.findAll();
        return securities.stream().map(Security::getSymbol).collect(Collectors.toList());
    }
}
