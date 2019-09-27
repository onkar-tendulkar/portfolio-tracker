package com.onkar.web;


import com.onkar.domain.Portfolio;
import com.onkar.repository.PortfolioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class PortfolioController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PortfolioRepository repo;


    @RequestMapping(value="/api/portfolio", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Portfolio> getPortfolio(@RequestParam("userId")Integer userId){
        logger.info("Fetching Portfolios for userId : "+userId);
        return repo.findPortfolioByUserId(userId);
    }

    @RequestMapping(value = "/api/portfolio", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    public @ResponseBody Portfolio addSecurity(@RequestBody Portfolio portfolio)
    {
        logger.info("Adding Portfolio : "+portfolio.getName()+", Symbol : "+portfolio.getUserId());
        repo.saveAndFlush(portfolio);
        logger.info("Added Portfolio id : "+portfolio.getId()+", Name : "+portfolio.getName()+", Symbol : "+portfolio.getUserId());
        return portfolio;
    }
}