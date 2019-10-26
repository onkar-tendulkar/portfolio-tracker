package com.onkar.web;


import com.onkar.dao.PortfolioSecurityDAO;
import com.onkar.domain.Portfolio;
import com.onkar.repository.PortfolioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class PortfolioController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PortfolioRepository repo;

    @Autowired
    private PortfolioSecurityDAO psDAO;


    /*Portfolio list*/
    @RequestMapping(value="/api/portfolio", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Portfolio> getPortfolios(@RequestParam("userId")Integer userId,@RequestParam("portfolioId") Optional<Long> portfolioId)
    {
        if(portfolioId.isPresent())
        {
            logger.info("Fetching portfolio without securities for id : "+portfolioId.get());
            return repo.findPortfolioByPortfolioIdUserId(portfolioId.get(), userId);
        }
        else
        {
            logger.info("Fetching Portfolios for userId : "+userId);
            return repo.findPortfolioByUserId(userId);
        }
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


}