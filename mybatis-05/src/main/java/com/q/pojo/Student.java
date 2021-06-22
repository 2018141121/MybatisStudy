package com.q.pojo;

import lombok.Data;

@Data
public class Student {

    private long id;
    private String name;
    private long tid;
    private int age;
    //    学生需要关联一个老师
    private Teacher teacher;
}
