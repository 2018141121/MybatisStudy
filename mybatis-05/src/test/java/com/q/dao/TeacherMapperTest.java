package com.q.dao;

import com.q.pojo.Student;
import com.q.pojo.Teacher;
import com.q.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {
    //    <!--
    //    思路：
    //    1.查询所有的学生信息
    //    2.根据查询出来的学生的tid，寻找对应的老师，也就是子查询
    //    这里是按照查询嵌套处理，查询出来学生的所有信息和对应的老师
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
