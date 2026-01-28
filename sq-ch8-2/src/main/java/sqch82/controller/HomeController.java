package sqch82.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(@RequestParam String color, @RequestParam String name, Model model) {
        model.addAttribute("color", color);
        model.addAttribute("username", name);
        return "home";
    }
    //@RequestParam to get the parameter's value from the Http request parameter having same name as of @Request Parameter's name.

    //@RequestParam(optional=true).
    //to make HTTp request parameters optional since by default they are mandatory.
}
