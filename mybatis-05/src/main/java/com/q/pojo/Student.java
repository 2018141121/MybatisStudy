package com.q.pojo;

import lombok.Data;

@Data
public class Student {

    private long id;
    private String name;
    private long tid;
    private int age;
    //    ѧ����Ҫ����һ����ʦ
    private Teacher teacher;
}
