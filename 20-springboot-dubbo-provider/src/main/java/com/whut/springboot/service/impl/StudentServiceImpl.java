package com.whut.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.whut.springboot.service.StudentService;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = StudentService.class,version = "1.0.0") // dubbo的注解，提供接口服务
public class StudentServiceImpl implements StudentService {

    @Override
    public Integer queryAllCount() {
        return 1000;
    }

}
