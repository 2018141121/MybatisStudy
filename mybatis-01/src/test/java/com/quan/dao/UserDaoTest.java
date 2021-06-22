package com.quan.dao;

import com.quan.pojo.User;
import com.quan.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        //1���sqlSession���� �õ�һ������
        SqlSession sqlsession = mybatisUtils.getSqlSession();

//        ��ʽ1:ִ��sql
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);

        }
//        �ر�sqlSession
        sqlsession.close();
    }

    //����id��ȡ��Ϣ
    @Test
    public void test1() {
        //1���sqlSession����
        SqlSession sqlsession = mybatisUtils.getSqlSession();
//        ��ʽ1:ִ��sql
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
//        �ر�sqlSession
        sqlsession.close();
    }

    @Test
    //��������
    public void testAdd() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int addUser = mapper.addUser(new User(10, "tom", "124"));
        System.out.println("�ı�" + addUser);

        //�ύ����  �������Ҫ��������©��
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    //��������
    public void updateUser() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int updateUser = mapper.updateUser(new User(3, "����", "14541561156"));

        System.out.println("�޸�" + updateUser + "������");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //�h���Ñ�
    public void deleteUser() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int deleteUser = mapper.deleteUser(1);
        System.out.println("deleteUser" + deleteUser + "��");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //ʹ������map�������в�������
    public void addUser2() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 6);
        map.put("name", "hello");
        map.put("pwd", "24321");
        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //ģ����ԃ
    public void getUserLike() {

        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        List<User> userLike = mapper.getUserLike("%l%");
        for (User user : userLike) {
            System.out.println(user);

        }

        sqlSession.commit();
        sqlSession.close();
    }
}

