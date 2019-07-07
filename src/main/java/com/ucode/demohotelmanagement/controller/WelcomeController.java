package com.ucode.demohotelmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/")
    public String main(Model model) {
        LOGGER.info("main / ");
        model.addAttribute("message", "user");
        return "welcome";
    }

    @GetMapping("/hello")
    public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        LOGGER.info("mainWithParam /hello ");
        model.addAttribute("message", name);
        return "welcome";
    }

}
