package com.q.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//����һ��������
//sqlSessionFactory--->>sqlSession


public class mybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;


    static {
        try {
            //��һ����ȡsqlSessionFactory���� ʹ��mybatis��һ��
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    �� SqlSessionFactory �л�ȡ SqlSession
//    ��Ȼ���� SqlSessionFactory������˼�壬���ǿ��Դ��л�� SqlSession ��ʵ����
//    SqlSession �ṩ�������ݿ�ִ�� SQL ������������з����������ͨ�� SqlSession ʵ����ֱ��ִ����ӳ��� SQL ��䡣���磺
    public static SqlSession getSqlSession() {

        return sqlSessionFactory.openSession();

    }

}



