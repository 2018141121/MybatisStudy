package com.q.dao;

import com.q.pojo.Student1;

import java.util.List;

public interface StudentMapper1 {

    //    �������С��20�����ѯ����tom��ѧ��,����������20С��30�����ѯjim��ѧ��,����30����ѯjack����Ϣ
    Student1 getStudent(int age);

    //    ��ѯ�Ľӿڣ�����һ�������ȥ��ͨ��set�ķ���ע��ֵ
    List<Student1> getInformation(Student1 student1);

    //    ��������
    int updateInformation(Student1 student1);

    //    ��������
    int insertData(Student1 student1);

    //    ������������
    List<Student1> bulkQuery(List<Integer> list);

    //�������
    int batchAdd(List<Student1> list);

    //����ɾ��
    int batchDeletion(List<Integer> list);


}
