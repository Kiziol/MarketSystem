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

    /**
     * 根据手机号查询用户
     * @param telephone long类型的手机号
     * @return User实体类
     */
    @Select("select * from market_user where telephone = #{telephone}")
    public User getByTelephone(@Param("telephone") long telephone);
}
