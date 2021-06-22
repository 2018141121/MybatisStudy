package com.q.dao;

import com.q.pojo.User;
import com.q.utils.mybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);

    //�����б߽� ��ҳ
    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();

        //RowBoundsʵ�ַ�ҳ
        RowBounds rowBounds = new RowBounds(1, 2);
        //ͨ��java����ʵ�ַ�ҳ
        List<Object> selectList = sqlSession.selectList("com.q.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (Object o : selectList) {
            System.out.println(o);
        }
        sqlSession.close();
    }


    //����ʹ��limitʵ�ַ�ҳ
    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);//��ʼ����
        map.put("pageSize", 2);//ҳ���С
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    //log4j����
    @Test
    public void log4j_test() {

        logger.info("info:������test_log4j");
        logger.debug("debug:������test_log4j");
        logger.error("error:������test_log4j");

    }


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


}

