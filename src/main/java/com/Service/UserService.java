package com.Service;

import com.Dao.UserDao;
import com.Result.CodeMsg;
import com.Util.MD5Util;
import com.Util.SaltUtil;
import com.Vo.LoginVo;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

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

    public CodeMsg login(LoginVo loginVo) {
        if(loginVo == null) {
            return CodeMsg.SERVER_ERROR;
        }
        long telephone = loginVo.getTelephone();
        String formPass = loginVo.getPassword();
        User user = getByTelephone(telephone);
        if(user == null) {
            return CodeMsg.TELEPHONE_NOT_EXIST;
        }
        String dbPass = user.getPassword();
        String salat = user.getSalt();
        String caclPass = MD5Util.formPassToDBPass(formPass, salat);
        if(!caclPass.equals(dbPass)) {
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;
    }
}
