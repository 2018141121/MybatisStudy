package com.q.utlis;

import java.util.UUID;

//建立一个工具类，实现随机获取id
public class IdUtlis {
    //随机获取id
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
