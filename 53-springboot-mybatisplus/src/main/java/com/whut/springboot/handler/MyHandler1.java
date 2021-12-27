package com.whut.springboot.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
    自动填充的两步
        1、属性上添加注解@TableField(fill = FieldFill.INSERT)
        2、创建类实现MetaObjectHandler
 */
@Component
@Slf4j
public class MyHandler1 implements MetaObjectHandler {

    // 添加操作，执行
    @Override
    public void insertFill(MetaObject metaObject) {
        // 属性名、属性值、元数据
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("version",1,metaObject);
        this.setFieldValByName("deleted",0,metaObject);
    }

    // 修改操作，执行
    @Override
    public void updateFill(MetaObject metaObject) {
        // 属性名、属性值、元数据
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }


}
