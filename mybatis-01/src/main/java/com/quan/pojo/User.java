package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ʵ����
//�Ժ����ʹ��lombok������
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String name;
    private String pwd;

}
