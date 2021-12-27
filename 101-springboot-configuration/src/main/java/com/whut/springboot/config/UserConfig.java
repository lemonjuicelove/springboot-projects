package com.whut.springboot.config;

import com.whut.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、配置类里使用@Bean标注在方法上给容器注册组件，默认是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方式
 *      Full(proxyBeanMethods = true)。外部调用时，SpringBoot总是会检查这个组件是否存在于容器中，如果有，就拿，没有新建一个。保证了单实例
 *      Lite(proxyBeanMethods = false)。外部调用时，每次调用都会创建一个新的对象
 *      有组件依赖时，使用Full，没有组件依赖，使用Lite
 *
 * 4、@Import(User.class)
 *      给容器中自动创建User.class的组件，默认名字是全类名
 *
 * 5、@ConditionalOnBean()：条件装配注解，满足指定的条件，才会进行组件注入
 *
 * 6、@ImportResource("classpath:beans.xml")：导入Spring的配置文件放入容器
 *
 * 7、@EnableConfigurationProperties(User.class)：
 *          1、开启Car配置绑定功能
 *          2、把Car自动注册到容器中
 */

// @ImportResource("classpath:beans.xml")
@Import(User.class)
@Configuration(proxyBeanMethods = true)
// @EnableConfigurationProperties(Car.class)
public class UserConfig {

    // @ConditionalOnBean(name = "user02")
    @Bean // 给容器中添加组件。方法名为组件的id，返回类型为组件类型，返回值是组件在容器中的实例。
    public User user01(){
        return new User("jack",18);
    }

    @Bean("user02") // 自定义组件的id
    public User user(){
        return new User("tom",18);
    }

}
