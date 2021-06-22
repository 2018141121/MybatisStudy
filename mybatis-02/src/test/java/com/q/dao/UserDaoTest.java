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
        //1获得sqlSession对象s
        SqlSession sqlsession = mybatisUtils.getSqlSession();
//        方式1:执行sql
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
//        关闭sqlSession
        sqlsession.close();
    }

    //根据id获取信息
    @Test
    public void test1() {
        //1获得sqlSession对象
        SqlSession sqlsession = mybatisUtils.getSqlSession();
//        方式1:执行sql
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
//        关闭sqlSession
        sqlsession.close();
    }

    @Test
    //插入数据
    public void test_add() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int addUser = mapper.addUser(new User(10, "tom", "124"));
        System.out.println("改变" + addUser);

        //提交事务  （这很重要，不能遗漏）
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //更新数据
    public void updateUser() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int updateUser = mapper.updateUser(new User(1, "ljq", "14541561156"));

        System.out.println("修改" + updateUser + "条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //刪除用戶
    public void deleteUser() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int deleteUser = mapper.deleteUser(1);
        System.out.println("deleteUser" + deleteUser + "个");
        sqlSession.commit();
        sqlSession.close();
    }

    //    测试结果集映射  ,就是数据库里面的字段名和我们设置的属性名不一致，要通过结果集映射来修改
    //    SqlSession开启了就要关闭，写代码的时候要一起写，就不会浪费资源
    @Test
    public void userById() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//通过反射得到对象的所有属性和方法
        UserTest userTest = mapper.userById(1);
        System.out.println(userTest);
        //关闭
        sqlSession.close();
    }
}

