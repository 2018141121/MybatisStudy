package com.q.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * �û�
 *
 * @author Administrator
 * @date 2021/05/24
 */
@Data
public class User implements Serializable {

    /**
     * id
     */
    private long id;
    /**
     * ����
     */
    private String name;
    /**
     * ����
     */
    private String pwd;


}
