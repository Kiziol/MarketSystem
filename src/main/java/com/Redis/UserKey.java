package com.Redis;

import com.domain.User;

public class UserKey extends BasePrefix{

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static UserKey token = new UserKey(TOKEN_EXPIRE,"token");

}
