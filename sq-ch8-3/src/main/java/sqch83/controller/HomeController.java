package sqch83.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("home/{color}")
    public String home(@PathVariable String color, Model model) {
        model.addAttribute("color", color);
        model.addAttribute("username","Jane");
        return "home";

    }
    //avoid using more then two HTTP path variables , since becomes difficult to handle
    //they are by default mandatory. (recommended not to use with optional values.
}
