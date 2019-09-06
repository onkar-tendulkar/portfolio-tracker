package com.onkar.web;


import com.onkar.domain.PortfolioSecurity;
import com.onkar.repository.PortfolioSecurityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PortfolioSecurityController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PortfolioSecurityRepository repo;


    @RequestMapping(value="/api/portfolio_security", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<PortfolioSecurity> getPortfolio(){
        
        return repo.findAll();

    }

    @RequestMapping(value = "/api/portfolioSecurity", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    public @ResponseBody PortfolioSecurity addSecurity(@RequestBody PortfolioSecurity portfolioSecurity)
    {
        logger.info("Adding Security to Portfolio : "+portfolioSecurity.getPortfolioId()+", Symbol : "+portfolioSecurity.getSymbol()+", Cost : "+portfolioSecurity.getSymbol()+", Date purchased : "+portfolioSecurity.getDatePurchased());
        repo.saveAndFlush(portfolioSecurity);

        return portfolioSecurity;
    }
}