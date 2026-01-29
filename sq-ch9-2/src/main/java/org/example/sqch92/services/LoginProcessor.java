package org.example.sqch92.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;
    private final LoggedUserManagementService loggedUserManagementService;
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public boolean login(){
        boolean loginResult = false;
        if(this.username.equals("natalie") && this.password.equals("password")){
            loginResult = true;
            loggedUserManagementService.setUsername(this.username);

        };
        return loginResult;
    }
}
