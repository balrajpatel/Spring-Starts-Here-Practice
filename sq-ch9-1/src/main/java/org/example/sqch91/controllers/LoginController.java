package org.example.sqch91.controllers;

import org.example.sqch91.services.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model){
        LoginProcessor loginProcessor = new LoginProcessor();
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();
        if(loggedIn){
            model.addAttribute("message", "You are logged in!");
        }
        else{
            model.addAttribute("message", "Invalid Credentials!");
        }
        return "login";
    }
}
