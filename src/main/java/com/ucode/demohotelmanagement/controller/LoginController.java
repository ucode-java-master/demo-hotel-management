package com.ucode.demohotelmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @GetMapping("/login")
    public String login(HttpSession session) {
        LOGGER.info("logging in");

        session.setAttribute("loggedIn", true);

        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        LOGGER.info("logging out");

        request.getSession().setAttribute("loggedIn", false);

        return "welcome";
    }

}
