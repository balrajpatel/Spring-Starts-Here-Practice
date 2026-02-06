package org.example.sqch101.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao!";
    }

    /*
            Instead of repeating the @ResponseBody
            annotation for each method, we replace
            @Controller with @RestController
     */
}
