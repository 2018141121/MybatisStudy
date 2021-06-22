package com.quan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


//第三步就是配置工具类，获取能解析sql语句的sqlSession对象，然后这个对象是存放在sqlSessionFactory工厂里面的
//sqlSessionFactory--->>sqlSession
public class mybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块，也就是不能修改的，存进房子里面的
    static {
        try {
            //第一步
            //    获取sqlSessionFactory对象 使用mybatis第一步
            //获取连接数据库的配置文件
            String resource = "mybatis-config.xml";
            //把数据库配置信息放进输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //然后工厂建造者Builder根据输入流的数据库信息建立一个数据库工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    从 SqlSessionFactory 中获取 SqlSession 也就是工人
    //    既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    //    SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。例如：

    public static SqlSession getSqlSession() {
        //有了数据库工厂，就要找工人，sqlSession就是工人
        return sqlSessionFactory.openSession();

    }

}



