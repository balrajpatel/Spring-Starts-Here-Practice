package org.example.sqch93.services;

import org.example.sqch93.services.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService ;
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;

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
        loginCountService.increment();
        boolean loginResult = false;
        if(this.username.equals("natalie") && this.password.equals("password")){
            loginResult = true;
            loggedUserManagementService.setUsername(this.username);

        };
        return loginResult;
    }
}
