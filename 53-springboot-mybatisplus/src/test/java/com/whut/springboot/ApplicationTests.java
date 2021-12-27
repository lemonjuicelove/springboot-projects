package com.whut.springboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whut.springboot.bean.User;
import com.whut.springboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class ApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    @DisplayName("查询总数量")
    void test1() {
        Integer integer = userMapper.selectCount(null);
        log.info("总量为：{}",integer);
    }

    @Test
    @DisplayName("添加操作")
    void test2(){
        User user = new User();
        user.setName("mary");
        user.setAge(22);
        user.setEmail("mary@qq.com");
        int insert = userMapper.insert(user);
        log.info(insert == 1 ? "插入成功" : "插入失败");
    }

    @Test
    @DisplayName("修改操作")
    void test3(){
        User user = new User();
        user.setId(6L);
        user.setAge(20);
        int update = userMapper.updateById(user);
        log.info(update == 1 ? "修改成功" : "修改失败");
    }

    @Test
    @DisplayName("测试乐观锁")
    void test4(){
        // 先查再改
        User user = userMapper.selectById(7L);
        user.setAge(80);
        int update = userMapper.updateById(user);
        log.info(update == 1 ? "修改成功" : "修改失败");
    }

    @Test
    @DisplayName("多个id批量查询")
    void test5(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        for (User user : users) {
            log.info(user.toString());
        }
    }

    @Test
    @DisplayName("分页测试")
    void test6(){
        // 当前页、每页的数量
        Page<User> page = new Page<>(2,3);
        // 把分页后的所有数据都封装到page对象里面
        userMapper.selectPage(page, null);
        List<User> users = page.getRecords();
        for (User user : users) {
            log.info(user.toString());
        }
    }

    @Test
    @DisplayName("物理删除")
    void test7(){
        int delete = userMapper.deleteById(7L);
        // userMapper.deleteBatchIds(Arrays.asList(1L,2L)); 批量删除
        log.info(delete == 1 ? "删除成功" : "删除失败");
    }

    @Test
    @DisplayName("逻辑删除")
    void test8(){
        int delete = userMapper.deleteById(7L);
        // userMapper.deleteBatchIds(Arrays.asList(1L,2L)); 批量删除
        log.info(delete == 1 ? "删除成功" : "删除失败");
    }

    @Test
    @DisplayName("自己写的语句")
    void test9(){
        Integer integer = userMapper.selectAllCount();
        log.info("总数：{}",integer);
    }

    @Test
    @DisplayName("复杂条件查询")
    void test10(){
        // 创建QueryWrapper对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // ge（>=）、gt(>)、le、lt、eq(==)、ne、between、notbetween、like、orderByDesc、last(拼接sql)

        // 字段、值
        queryWrapper.ge("age",20);
        // queryWrapper.eq("name","luka");
        // queryWrapper.select("id","name"); 查询指定的列
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);

    }

}
