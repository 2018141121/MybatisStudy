package com.q.dao;

import com.q.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //��ѯ����ѧ������Ϣ���Լ���Ӧ����ʦ
    List<Student> getStudent();

    List<Student> getStudent2();

    List<Student> getStudent1(int age);
}
