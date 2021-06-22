package com.q.dao;


import com.q.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//ʹ��ע�⿪��
public interface UserMapper {

    @Select("select * from user")
    List<User> getUser();

    //�������ڶ��������ʱ���Ҫʹ��paramע��
    @Select("select *from user where id= #{id}")

    User getUserById(@Param("id") int id);

    //����
    @Insert("insert into  user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    //�޸�
    @Update("update user set name=#{name},id=#{id},pwd=#{pwd} where id=#{id} ")
    int updateUser(User user);

    //�h��
    @Delete("delete from user where id =#{id} ")
    int deleteUser(@Param("id") int id);

    //ģ����ѯ
    @Select("select * from user where name like  #{value}")
    List<User> selectUser(String s);
}

