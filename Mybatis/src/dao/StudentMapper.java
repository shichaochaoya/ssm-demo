package dao;

import entity.Student;
import entity.Teacher;

public interface StudentMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String sid);

    Teacher selectByPrimaryKeyWithTeacher(String sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}