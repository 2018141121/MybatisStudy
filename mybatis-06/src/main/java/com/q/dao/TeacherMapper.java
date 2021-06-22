package com.q.dao;

import com.q.pojo.Teacher1;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {


    Teacher1 getTeacher(@Param("id") int id);

}
