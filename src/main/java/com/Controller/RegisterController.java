package com.Controller;

import com.Service.UserService;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping("register")
    public String registerForm() {
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registerSubmit(User user) {
        userService.addUser(user);
        return "login";
    }

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }
}
