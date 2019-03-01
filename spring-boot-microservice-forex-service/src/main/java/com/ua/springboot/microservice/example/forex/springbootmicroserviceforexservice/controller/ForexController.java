package com.ua.springboot.microservice.example.forex.springbootmicroserviceforexservice.controller;

import com.ua.springboot.microservice.example.forex.springbootmicroserviceforexservice.models.ExchangeValue;
import com.ua.springboot.microservice.example.forex.springbootmicroserviceforexservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class ForexController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }
}
