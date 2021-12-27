package com.whut.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whut.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    Integer selectAllCount();
}
