package com.q.pojo;

//ʵ����

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String name;
    private String pwd;


}
