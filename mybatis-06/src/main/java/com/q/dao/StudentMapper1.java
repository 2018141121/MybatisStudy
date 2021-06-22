package com.q.dao;

import com.q.pojo.Student1;

import java.util.List;

public interface StudentMapper1 {

    //    如果年龄小于20，则查询姓名tom的学生,如果年龄大于20小于30，则查询jim的学生,大于30，查询jack的信息
    Student1 getStudent(int age);

    //    查询的接口，传递一个对象过去，通过set的方法注入值
    List<Student1> getInformation(Student1 student1);

    //    更新数据
    int updateInformation(Student1 student1);

    //    插入数据
    int insertData(Student1 student1);

    //    批量查找数据
    List<Student1> bulkQuery(List<Integer> list);

    //批量添加
    int batchAdd(List<Student1> list);

    //批量删除
    int batchDeletion(List<Integer> list);


}
