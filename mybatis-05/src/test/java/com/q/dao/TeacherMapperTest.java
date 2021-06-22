package com.q.dao;

import com.q.pojo.Student;
import com.q.pojo.Teacher;
import com.q.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {
    //    <!--
    //    ˼·��
    //    1.��ѯ���е�ѧ����Ϣ
    //    2.���ݲ�ѯ������ѧ����tid��Ѱ�Ҷ�Ӧ����ʦ��Ҳ�����Ӳ�ѯ
    //    �����ǰ��ղ�ѯǶ�״�����ѯ����ѧ����������Ϣ�Ͷ�Ӧ����ʦ
    @Test
    public void test() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        for (Student student1 : student) {
            System.out.println(student1);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent2();
        for (Student student1 : student) {
            System.out.println(student1);
        }
        sqlSession.close();
    }

    @Test
    public void teacher01() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher1 = mapper.getTeacher1(1);
        System.out.println(teacher1);
        sqlSession.close();
    }


    @Test
    public void student01() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> student1 = mapper.getStudent1(20);
        for (Student student : student1) {
            System.out.println(student);
        }
        sqlSession.close();
    }

}
