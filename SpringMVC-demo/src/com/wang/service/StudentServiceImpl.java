package com.wang.service;

import com.wang.dao.StudentMapper;
import com.wang.entity.Student;
import com.wang.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherService teacherService;

    @Override
    @Transactional//事务标记
    // 事务隔离机制7中，默认是REQUIRED表示如果上下文已存在事务就加入，如果没有新建事务
    public int createStudent(Student student) {
        studentMapper.insertSelective(student);
        /*Teacher teacher=new Teacher();
        teacher.setTid(4);//故意重复 teacher插入不进去导致整条事务都回滚，student也无法插入
        teacher.setUsername("wang");
        teacher.setPassword("123456");
        teacherService.createTeacher(teacher);*/
        return 0;
    }

    @Override
    public Student selectStudent(String sid) {
        Student student = studentMapper.selectByPrimaryKey(sid);
        return student;
    }
}
