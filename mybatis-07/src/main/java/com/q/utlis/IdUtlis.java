package com.q.utlis;

import java.util.UUID;

//����һ�������࣬ʵ�������ȡid
public class IdUtlis {
    //�����ȡid
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
