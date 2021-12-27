package com.whut.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.whut.springboot.mapper.StudentMapper;
import com.whut.springboot.model.Student;
import com.whut.springboot.service.StudentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Service(interfaceClass = StudentService.class,version = "1.0.0")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {

        return studentMapper.selectByPrimaryKey(id);
    }

}
