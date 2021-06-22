package com.q.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher1 {

    private long id;
    private String name;
    //一个老师对多个学生，也就是一对多  返回的是一个集合，就是会有很多对象
    private List<Student1> students;
}
