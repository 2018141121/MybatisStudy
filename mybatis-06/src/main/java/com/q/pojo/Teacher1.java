package com.q.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher1 {

    private long id;
    private String name;
    //һ����ʦ�Զ��ѧ����Ҳ����һ�Զ�  ���ص���һ�����ϣ����ǻ��кܶ����
    private List<Student1> students;
}
