package com.onkar.web;


import com.onkar.domain.Security;
import com.onkar.repository.SecurityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SecurityController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SecurityRepository repo;
    @RequestMapping("/security")
    public String index(Model model){
        model.addAttribute("security", repo.findAll());
        return "index";
    }

    @RequestMapping(value="/api/security", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Security> getSecurity(){
        
        return repo.findAll();

    }

    @RequestMapping(value = "/api/security", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    public @ResponseBody Security addSecurity(@RequestBody Security security)
    {
        logger.info("Adding Security : "+security.getName()+", Symbol : "+security.getSymbol());
        repo.saveAndFlush(security);
        return security;
    }
}