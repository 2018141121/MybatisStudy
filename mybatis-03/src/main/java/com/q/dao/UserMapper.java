package com.q.dao;

import com.q.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    //    分页
    List<User> getUserByLimit(Map<String, Integer> map);

    //    分页2
    List<User> getUserByRowBounds();

    //查询所有信息
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //??插入对象信息
    int addUser(User user);

    //更新
    int updateUser(User user);

    //根据id删除信息
    int deleteUser(int id);

}
