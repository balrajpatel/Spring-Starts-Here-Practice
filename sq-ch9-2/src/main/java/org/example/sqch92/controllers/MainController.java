package org.example.sqch92.controllers;

import org.example.sqch92.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model) {
        String username = loggedUserManagementService.getUsername();
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
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


