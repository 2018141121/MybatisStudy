package com.q.dao;

import com.q.pojo.User;
import com.q.pojo.UserTest;
import com.q.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class UserDaoTest {
    @Test
    public void test() {
        //1���sqlSession����s
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
    public void test_add() {
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
        int updateUser = mapper.updateUser(new User(1, "ljq", "14541561156"));

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

    //    ���Խ����ӳ��  ,�������ݿ�������ֶ������������õ���������һ�£�Ҫͨ�������ӳ�����޸�
    //    SqlSession�����˾�Ҫ�رգ�д�����ʱ��Ҫһ��д���Ͳ����˷���Դ
    @Test
    public void userById() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//ͨ������õ�������������Ժͷ���
        UserTest userTest = mapper.userById(1);
        System.out.println(userTest);
        //�ر�
        sqlSession.close();
    }
}

