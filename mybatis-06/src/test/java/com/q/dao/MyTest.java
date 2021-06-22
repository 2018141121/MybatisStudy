package com.q.dao;

import com.q.pojo.Student1;
import com.q.pojo.Teacher1;
import com.q.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    Student1 student2 = new Student1();

    @Test
    public void test() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher1 teacher1 = mapper.getTeacher(1);
        System.out.println(teacher1);
        sqlSession.close();
    }

    @Test
    public void test1() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper1 mapper = sqlSession.getMapper(StudentMapper1.class);

        Student1 student = mapper.getStudent(19);
        System.out.println(student);
        sqlSession.close();
    }


    @Test
    public void test002() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper1 mapper = sqlSession.getMapper(StudentMapper1.class);

        Student1 student1 = new Student1();
        student1.setAge(19);
        System.out.println("根据年龄查找：");
        List<Student1> information = mapper.getInformation(student1);
        for (Student1 information1 : information) {
            System.out.println(information1);
        }
        sqlSession.close();
    }


    @Test
    public void test03() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper1 mapper = sqlSession.getMapper(StudentMapper1.class);
        student2.setName("i");
        System.out.println("根据模糊姓名查找信息：");
        List<Student1> information = mapper.getInformation(student2);
        for (Student1 information1 : information) {
            System.out.println(information1);
        }
        sqlSession.close();
    }

    @Test
    public void test04() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper1 mapper = sqlSession.getMapper(StudentMapper1.class);
        student2.setId(1);
        System.out.println("根据id查找信息：");
        List<Student1> information = mapper.getInformation(student2);
        for (Student1 information1 : information) {
            System.out.println(information1);
        }
        sqlSession.close();
    }

    @Test
    public void test05() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper1 mapper = sqlSession.getMapper(StudentMapper1.class);
        student2.setId(1);
        student2.setName("helloWord！");
        student2.setTid(2);
        System.out.println("更新数据：");
        int i = mapper.updateInformation(student2);
        System.out.println(i);
        sqlSession.close();
    }


    @Test
    public void test06() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper1 mapper = sqlSession.getMapper(StudentMapper1.class);

        student2.setName("helloWord2！");
        student2.setTid(2);
        student2.setAge(34);
        System.out.println("插入数据：");
        int i = mapper.insertData(student2);
        System.out.println("插入了" + i + "数据");
        sqlSession.close();
    }
}
