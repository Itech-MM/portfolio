package com.flexitech.app.portfolio.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BasedController {
    @ModelAttribute("pageTitle")
    public String pageTitle(){
        return "Flexitech";
    }
}
