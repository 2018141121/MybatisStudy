package com.q.dao;

import com.q.pojo.User;
import com.q.pojo.UserTest;

import java.util.List;

/*
配置接口，让mapper去实现，在mapper里面实现sql语句
 */

public interface UserMapper {
    //查询所有用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //添加一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //根据id刪除用戶
    int deleteUser(int id);

    //根据id查找用户，返回的是UserTest类型的对象    结果集映射到这个userTest这个实体类里
    UserTest userById(int id);


}
