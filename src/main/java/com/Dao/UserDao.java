package com.Dao;

import com.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    /**
     *添加用户
     * @Param User 用户实体类
     * @return 执行成功的条数
     */
    @Insert("insert into market_user(telephone, email, password, salt, name, company, qq) values(#{telephone}, " +
            "#{email}, #{password}, #{salt}, #{name}, #{company}, #{qq})")
    public int addUser(User user);

}
