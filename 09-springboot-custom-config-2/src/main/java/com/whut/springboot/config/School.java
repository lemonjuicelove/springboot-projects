package com.whut.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才可以这样进行绑定
 */
@Component // 将此类交给spring容器进行管理
@ConfigurationProperties(prefix = "school") // 配置属性注解，前缀名和配置文件中的前缀名一致
public class School {

    private String name;
    private String websit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsit() {
        return websit;
    }

    public void setWebsit(String websit) {
        this.websit = websit;
    }
}
