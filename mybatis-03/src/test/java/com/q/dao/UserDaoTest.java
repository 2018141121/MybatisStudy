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

    //按照行边界 分页
    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();

        //RowBounds实现分页
        RowBounds rowBounds = new RowBounds(1, 2);
        //通过java代码实现分页
        List<Object> selectList = sqlSession.selectList("com.q.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (Object o : selectList) {
            System.out.println(o);
        }
        sqlSession.close();
    }


    //测试使用limit实现分页
    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);//起始索引
        map.put("pageSize", 2);//页面大小
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    //log4j测试
    @Test
    public void log4j_test() {

        logger.info("info:进入了test_log4j");
        logger.debug("debug:进入了test_log4j");
        logger.error("error:进入了test_log4j");

    }


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


}

