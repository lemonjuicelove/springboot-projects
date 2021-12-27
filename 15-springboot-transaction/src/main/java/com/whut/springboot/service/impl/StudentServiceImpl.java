package com.whut.springboot.service.impl;

import com.whut.springboot.mapper.StudentMapper;
import com.whut.springboot.model.Student;
import com.whut.springboot.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Transactional // 事务注解，表示开启事务
    @Override
    public int updateStudentById(Student student) {

        int i = studentMapper.updateByPrimaryKeySelective(student);

        int a = 10 / 0;

        return i;
    }

}
