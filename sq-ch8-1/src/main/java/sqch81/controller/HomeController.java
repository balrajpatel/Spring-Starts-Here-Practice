package sqch81.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model page){
        page.addAttribute("username", "Katy");
        page.addAttribute("color","red");
        return "home";

    }
}
