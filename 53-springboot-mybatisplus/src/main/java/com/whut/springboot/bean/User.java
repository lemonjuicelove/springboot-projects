package com.whut.springboot.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /*
        IdType.AUTO：自动增长(不是从数据库表中最后一个id开始增长，是从自己内部算的一个值开始增长)
        IdType.NONE：没有策略
        IdType.INPUT：自己输入
        IdType.UUID：全局唯一id
        IdType.ID_WORKER：mp自带策略，属性类型是数字类型
        IdType.ID_WORKER_STR：mp自带策略，属性类型是字符串类型
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;

    // 自动填充，添加时必须有值
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    // 自动填充，添加、修改时必须有值
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    @TableField(fill = FieldFill.INSERT)
    @Version // 乐观锁的注解
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic // 逻辑删除注解
    private Integer deleted;

}
