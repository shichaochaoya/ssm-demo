package com.wang.dao;

import com.wang.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tid);
    Teacher selectByPrimaryKeyWithStudent(Integer tid);
    List<Teacher> selectByTids(@Param("tids") List<Integer> tids);



    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}