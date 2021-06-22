package com.q.dao;

import com.q.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface User_Mapper {
    //    ??????е????
    User secretUser(@Param("id") int id);
}
