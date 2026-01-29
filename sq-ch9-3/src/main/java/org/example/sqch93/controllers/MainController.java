package org.example.sqch93.controllers;

import org.example.sqch93.services.LoggedUserManagementService;
import org.example.sqch93.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model) {
        String username = loggedUserManagementService.getUsername();
        int count = loginCountService.getCount();
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("loginCount",count);
        return "main";
    }
}

    /*
    Is logout a request parameter? ✅
        Yes.
        This is equivalent to:
        logout=
        So:
        Parameter name → logout
        Parameter value → empty string
        In Spring MVC:
        This is a flag-style parameter.
        Meaning:
        “If this parameter exists, do logout logic”

        <a> always sends GET



        This is how controller calls the action based on HTTP request
        (this getMapping handling two intentions)
        The two actual HTTP requests
        🔹 Case 1: User visits home page
        GET /main
        No request parameters.
        Spring calls:
        home(null, model)

        🔹 Case 2: User clicks logout
        GET /main?logout
        Spring calls:
        home("","model")   // logout is present
        So yes — same method, two different requests.
     */


