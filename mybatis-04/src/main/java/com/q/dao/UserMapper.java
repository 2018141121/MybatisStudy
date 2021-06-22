package com.q.dao;


import com.q.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//使用注解开发
public interface UserMapper {

    @Select("select * from user")
    List<User> getUser();

    //方法存在多个参数的时候就要使用param注解
    @Select("select *from user where id= #{id}")

    User getUserById(@Param("id") int id);

    //增加
    @Insert("insert into  user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    //修改
    @Update("update user set name=#{name},id=#{id},pwd=#{pwd} where id=#{id} ")
    int updateUser(User user);

    //刪除
    @Delete("delete from user where id =#{id} ")
    int deleteUser(@Param("id") int id);

    //模糊查询
    @Select("select * from user where name like  #{value}")
    List<User> selectUser(String s);
}

