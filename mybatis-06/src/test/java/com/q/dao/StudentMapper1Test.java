package com.q.dao;

import com.q.pojo.Student1;
import com.q.utils.mybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentMapper1Test
 * @Author 小林
 * @Date 2021/4/8 11:29
 * @describe: [批量处理测试类]
 **/
public class StudentMapper1Test extends TestCase {

    public void testBatchAdd() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper1 mapper = sqlSession.getMapper(StudentMapper1.class);

        ArrayList<Student1> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Student1 student1 = new Student1();
            student1.setId(i);
            student1.setName("ljq" + i);
            student1.setTid(1);
            student1.setAge(23);
            list.add(student1);
        }
        System.out.println("批量增加：");
        int i = mapper.batchAdd(list);
        for (Student1 student1 : list) {
            System.out.println(student1.getId());
        }
        sqlSession.close();
    }


    public void testBatchDeletion() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper1 mapper = sqlSession.getMapper(StudentMapper1.class);
        System.out.println("批量删除数据");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        int i = mapper.batchDeletion(list);

        System.out.println(i);
        sqlSession.close();
    }

    public void test1() {

        SqlSession sqlSession = mybatisUtils.getSqlSession();
        StudentMapper1 mapper = sqlSession.getMapper(StudentMapper1.class);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("批量查询：");
        List<Student1> student1s = mapper.bulkQuery(list);

        for (Student1 student1 : student1s) {
            System.out.println(student1);
        }
        sqlSession.close();
    }


}