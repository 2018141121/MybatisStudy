package com.quan.dao;

import com.quan.pojo.User;

import java.util.List;
import java.util.Map;

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

    //使用万能的map插入一个用户
    int addUser2(Map<String, Object> map);

    //模糊查询
    List<User> getUserLike(String s);
}