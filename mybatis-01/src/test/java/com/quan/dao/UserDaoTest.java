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
        //1获得sqlSession对象 得到一个工人
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
    public void testAdd() {
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
        int updateUser = mapper.updateUser(new User(3, "靓仔", "14541561156"));

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

    @Test
    //使用万能map方法进行插入数据
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
    //模糊查詢
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

