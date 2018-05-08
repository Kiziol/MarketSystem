package com.Service;

import com.Dao.UserDao;
import com.Redis.RedisService;
import com.Redis.UserKey;
import com.Result.CodeMsg;
import com.Util.MD5Util;
import com.Util.SaltUtil;
import com.Util.UUIDUtil;
import com.Vo.LoginVo;
import com.domain.User;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserService {

    public static final String COOKI_NAME_TOKEN = "token";

    @Autowired
    UserDao userDao;

    @Autowired
    RedisService redisService;

    public boolean addUser(User user) {
        String salt = SaltUtil.getSalt(16);
        user.setSalt(salt);
        user.setPassword(MD5Util.inputPassToDBPass(user.getPassword(), salt));
        userDao.addUser(user);
        return true;
    }

    public User getByTelephone(long telephone) {
        return userDao.getByTelephone(telephone);
    }

    public CodeMsg login(HttpServletRequest request, LoginVo loginVo) {
        if(loginVo == null) {
            return CodeMsg.SERVER_ERROR;
        }
        long telephone = loginVo.getTelephone();
        String formPass = loginVo.getPassword();
        User user = getByTelephone(telephone);
        if(user == null) {
            return CodeMsg.TELEPHONE_NOT_EXIST;
        }
        //验证密码
        String dbPass = user.getPassword();
        String salat = user.getSalt();
        String caclPass = MD5Util.formPassToDBPass(formPass, salat);
        if(!caclPass.equals(dbPass)) {
            return CodeMsg.PASSWORD_ERROR;
        }
        //生成cookie
        /*
        String token = UUIDUtil.uuid();
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
        */
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return CodeMsg.SUCCESS;
    }
}
