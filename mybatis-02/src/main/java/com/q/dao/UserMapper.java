package com.q.dao;

import com.q.pojo.User;
import com.q.pojo.UserTest;

import java.util.List;

/*
���ýӿڣ���mapperȥʵ�֣���mapper����ʵ��sql���
 */

public interface UserMapper {
    //��ѯ�����û�
    List<User> getUserList();

    //����id��ѯ�û�
    User getUserById(int id);

    //���һ���û�
    int addUser(User user);

    //�޸��û�
    int updateUser(User user);

    //����id�h���Ñ�
    int deleteUser(int id);

    //����id�����û������ص���UserTest���͵Ķ���    �����ӳ�䵽���userTest���ʵ������
    UserTest userById(int id);


}
