springboot在核心配置文件中将自定义配置映射到一个对象：@ConfigurationProperties注解
@ConfigurationProperties(prefix = "")：
        配置属性注解，被注解的类为属性配置类，
        配置文件中的前缀名要统一，配置文件中同名的值会自动注入到类中同名的属性