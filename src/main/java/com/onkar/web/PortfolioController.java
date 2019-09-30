package com.onkar.web;


import com.onkar.domain.Portfolio;
import com.onkar.domain.PortfolioSecurity;
import com.onkar.repository.PortfolioRepository;
import com.onkar.repository.PortfolioSecurityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class PortfolioController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PortfolioRepository repo;

    @Autowired
    PortfolioSecurityRepository repoPS;


    /*Portfolio list*/
    @RequestMapping(value="/api/portfolio", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Portfolio> getPortfolios(@RequestParam("userId")Integer userId){
        logger.info("Fetching Portfolios for userId : "+userId);
        return repo.findPortfolioByUserId(userId);
    }

    /*Portfolio object*/
    @RequestMapping(value = "/api/portfolio", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    public @ResponseBody Portfolio addPortfolio(@RequestBody Portfolio portfolio)
    {
        logger.info("Adding Portfolio : "+portfolio.getName()+", Symbol : "+portfolio.getUserId());
        repo.saveAndFlush(portfolio);
        logger.info("Added Portfolio id : "+portfolio.getId()+", Name : "+portfolio.getName()+", Symbol : "+portfolio.getUserId());
        return portfolio;
    }

    /*Portfolio security*/
    @RequestMapping(value="/api/portfolio_security", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody Portfolio getPortfoliosSecurity(@RequestParam("portfolioId")Integer id){
        logger.info("Fetching securities for portfolioId : "+id);
        return repo.findById(new Long(id.longValue())).get();
    }


    @RequestMapping(value="/api/ps", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<PortfolioSecurity> getPS(@RequestParam("userId")Integer userId,
                                                 @RequestParam("symbol")String symbol)
    {
        return repoPS.findPortfoliosWithMatchingSecurity(userId,symbol);
    }
}