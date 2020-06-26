package com.example.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfiguarationController {

    @Autowired
    Configuarations config;



    @GetMapping(path="/limits")
    public LimitsConfiguaration retriveLimitsFromConfiguaration(){
        return new LimitsConfiguaration(config.getMax(),config.getMin());
    }
}
