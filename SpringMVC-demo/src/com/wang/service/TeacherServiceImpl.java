package com.wang.service;

import com.wang.dao.TeacherMapper;
import com.wang.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    //Transactional 标注事务,增删改查都添加,
    // rollbackFor：抛出如下异常回滚，noRollbackFor发生如下异常不用处理
    //事务隔离机制7中，默认是REQUIRED表示如果上下文已存在事务就加入，如果没有新建事务
    public int createTeacher(Teacher teacher) {
        teacherMapper.insertSelective(teacher);
        return 0;
    }
}
