package com.Controller;

import com.Result.Result;
import com.Service.UserService;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;


    @RequestMapping("/demo")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "spring");
        return "hello";
    }
    @RequestMapping("db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user = userService.getById(1);
        return Result.success(user);
    }

}
