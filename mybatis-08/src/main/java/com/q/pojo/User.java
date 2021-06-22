package com.q.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * ÓÃ»§
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
     * Ãû×Ö
     */
    private String name;
    /**
     * ÃÜÂë
     */
    private String pwd;


}
