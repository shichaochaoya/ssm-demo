package com.wang.service;

import com.wang.entity.Student;

import java.util.List;

//insert select delete 在dao（数据库）层使用
//create 使用与service 让人能读懂
public interface StudentService {
    int createStudent(Student student);
    Student selectStudent(String sid);

}
