package com.onkar.web;


import com.onkar.dao.PortfolioSecurityDAO;
import com.onkar.domain.Portfolio;
import com.onkar.domain.PortfolioSecurity;
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
public class PortfolioSecurityController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PortfolioSecurityDAO psDAO;

    @RequestMapping(value="/api/portfolio_security", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<PortfolioSecurity> getPortfolioSecurities(@RequestParam("userId")Integer userId,
                                                 @RequestParam("symbol")Optional<String> symbol,
                                                       @RequestParam("portfolioId")Optional<Long> portfolioId)
    {
        if(symbol.isPresent())
        {
            logger.info("Fetching portfolios with security : "+symbol.get());
            return psDAO.findPortfoliosWithMatchingSecurity(userId,symbol.get());
        }
        if(portfolioId.isPresent())
        {
            logger.info("Fetching securities for portfolioId : "+portfolioId+", userId : "+userId);
            return psDAO.findSecuritiesInPortfolio(userId,portfolioId.get());
        }
        return null;
    }

    @RequestMapping(value="/api/portfolio_security", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    public @ResponseBody PortfolioSecurity insert(@RequestBody PortfolioSecurity portfolioSecurity)
    {
        logger.info("Adding Security to Portfolio : "+portfolioSecurity.getPortfolioId()+", Symbol : "+portfolioSecurity.getSymbol());
        psDAO.addSecurityToPortfolio(portfolioSecurity);
        logger.info("Added Security to Portfolio : "+portfolioSecurity.getPortfolioId()+", Symbol : "+portfolioSecurity.getSymbol());
        return portfolioSecurity;
    }
}