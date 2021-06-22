package com.q.dao;

import com.q.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    //    @Select("select * from teacher where id=#{id}")
    Teacher getTeacher1(@Param("tid") int id);
}
