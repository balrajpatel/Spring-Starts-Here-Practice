package org.example.sqch93.controllers;

import org.example.sqch93.services.LoginCountService;
import org.example.sqch93.services.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;
    public LoginController(LoginProcessor loginProcessor, LoginCountService loginCountService) {
        this.loginProcessor = loginProcessor;

    }
    @GetMapping("/")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model){

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();
        if(loggedIn){
            model.addAttribute("message", "You are logged in!");
            return "redirect:/main";
        }
        else{
            model.addAttribute("message", "Invalid Credentials!");
            return "login";
        }

    }
}
