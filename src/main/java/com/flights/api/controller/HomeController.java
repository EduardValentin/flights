package com.flights.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final String apiEndpoint;

    public HomeController(@Value("${api.endpoint}") String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("host", apiEndpoint);
        return "index";
    }
}
