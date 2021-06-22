package com.q.dao;

import com.q.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有学生的信息，以及对应的老师
    List<Student> getStudent();

    List<Student> getStudent2();

    List<Student> getStudent1(int age);
}
