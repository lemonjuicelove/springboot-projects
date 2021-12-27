package com.whut.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.whut.springboot.mapper.StudentMapper;
import com.whut.springboot.model.Student;
import com.whut.springboot.service.StudentService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Component
@Service(interfaceName = "com.whut.springboot.service.StudentService",version = "1.0.0")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Integer queryStudentCount() {

        // 去redis缓存中查询，如果有，直接使用，如果没有，去数据库查询并存放到redis缓存中
        Integer allCount = (Integer) redisTemplate.opsForValue().get("allCount");

        System.out.println(allCount);

        if (allCount == null){
            // 去数据库查询
            allCount = studentMapper.selectAllCount();
            // 存放到redis中
            redisTemplate.opsForValue().set("allCount",allCount,30, TimeUnit.SECONDS);
        }

        return allCount;
    }

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

}
