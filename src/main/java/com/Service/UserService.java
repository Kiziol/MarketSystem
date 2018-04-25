package com.Service;

import com.Dao.UserDao;
import com.Util.MD5Util;
import com.Util.SaltUtil;
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
}
