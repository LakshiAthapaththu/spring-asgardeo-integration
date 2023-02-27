package com.asgardeo.demo.springasgardeointegration.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model,
                       @AuthenticationPrincipal OidcUser oidcUser) {

        model.addAttribute("userName", oidcUser.getAttribute("username"));
        model.addAttribute("firstName", oidcUser.getAttribute("given_name"));
        model.addAttribute("lastName", oidcUser.getAttribute("family_name"));
        model.addAttribute("phoneNumber", oidcUser.getAttribute("phone_number"));
        model.addAttribute("country", oidcUser.getAddress().getCountry());

        return "home";
    }
}
