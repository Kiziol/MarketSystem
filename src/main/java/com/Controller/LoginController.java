package com.Controller;

import com.Result.CodeMsg;
import com.Result.Result;
import com.Service.UserService;
import com.Util.ValidatorUtil;
import com.Vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    public String loginForm() {
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletRequest request, LoginVo loginVo) {
        //参数校验
        String passInput = loginVo.getPassword();
        String telephone = loginVo.getTelephone().toString();
        if(StringUtils.isEmpty(passInput)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if(StringUtils.isEmpty(telephone)) {
            return Result.error(CodeMsg.TELEPHONE_EMPTY);
        }
        if(!ValidatorUtil.isTelephone(telephone)) {
            return Result.error(CodeMsg.TELEPHONE_ERROR);
        }
        //登录
        CodeMsg codeMsg = userService.login(request, loginVo);
        if(codeMsg.getCode() == 0) {
            return Result.success(true);
        } else {
            return Result.error(codeMsg);
        }
    }

}
