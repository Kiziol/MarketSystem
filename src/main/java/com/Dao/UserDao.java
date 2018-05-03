package com.Dao;

import com.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    /**
     * 向数据库添加用户
     * @Param User 用户实体类
     * @return 执行成功的条数
     */
    @Insert("insert into market_user(telephone, email, password, salt, name, qq) values(#{telephone}, " +
            "#{email}, #{password}, #{salt}, #{name}, #{qq})")
    public int addUser(User user);

    @Select("select * from market_user where telephone = #{telephone}")
    public User getByTelephone(@Param("telephone") long telephone);
}
