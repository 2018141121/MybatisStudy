package com.q.pojo;

import lombok.Data;

import java.util.Date;

// µÃÂ¿‡
@Data
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date create_time;
    private long views;
}
