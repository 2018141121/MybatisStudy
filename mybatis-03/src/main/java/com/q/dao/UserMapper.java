package com.q.dao;

import com.q.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    //    ��ҳ
    List<User> getUserByLimit(Map<String, Integer> map);

    //    ��ҳ2
    List<User> getUserByRowBounds();

    //��ѯ������Ϣ
    List<User> getUserList();

    //����id��ѯ�û�
    User getUserById(int id);

    //??���������Ϣ
    int addUser(User user);

    //����
    int updateUser(User user);

    //����idɾ����Ϣ
    int deleteUser(int id);

}
