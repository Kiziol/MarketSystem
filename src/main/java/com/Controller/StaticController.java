package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StaticController {
    @RequestMapping("/home")
    public String toHome() {
        return "home";
    }
    @RequestMapping("/contact")
    public String toContact() {
        return "contact";
    }
    @RequestMapping("/shopping")
    public String toShopping() {
        return "shopping";
    }
    @RequestMapping("/about")
    public String toAbout() {
        return "about";
    }
}
