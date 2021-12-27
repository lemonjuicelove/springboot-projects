springboot集成mybatis
    a.添加mybatis依赖，MySQL驱动依赖
    b.使用MyBatis提供的逆向工程生成实体bean，映射文件，dao接口

SpringBoot集成MyBatis，最主要的两个注解@Mapper,@MapperScan
@Mapper：需要在每一个Mapper接口类上添加，作用是扫描dao接口创建dao对象
@MapperScan：在SpringBoot启动入口类上添加，作用是扫描指定的包下的Mapper接口类，创建dao对象

关于Mapper映射文件存放的位置有两种写法：
1.将Mapper接口和Mapper映射文件存放到同一目录下，需要在pom文件中手动指定资源文件夹路径的resources
2.将Mapper接口和Mapper映射文件分开存放，Mapper接口位置不变，Mapper映射文件存放到resources(类路径)下
  需要在springboot核心配置文件中指定mapper映射文件存放的位置