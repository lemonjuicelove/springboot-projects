package com.whut.springboot.bean;

import lombok.*;

@Data // getter setter方法
@ToString // toString方法
@AllArgsConstructor // 全参构造器
@NoArgsConstructor // 无参构造器
@EqualsAndHashCode 
public class User {

    private String name;
    private Integer age;

}
