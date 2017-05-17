#优雅的SSM架构(Spring+SpringMVC+Mybatis）
- Maven
- Spring（IOC DI AOP 声明式事务处理）
- SpringMVC（支持Restful风格）
- Hibernate Validate（参数校验）
- Mybatis（最少配置方案）
- Quartz时间调度
- Redis缓存（ProtoStuff序列化）
- [Redis Sentinel主从高可用方案](http://wosyingjun.iteye.com/blog/2289593)
- [Redis Cluster集群高可用方案](http://wosyingjun.iteye.com/blog/2289220)
- [Druid（数据源配置 sql防注入 sql性能监控)](http://wosyingjun.iteye.com/blog/2306139)
- 统一的异常处理    **GlobalException.java**
- JSP JSTL JavaScript
- Sping Shiro权限控制（待完善）
- Thymeleaf模板引擎
- Springside4工具包/ApacheCommons/Guava工具包
- MybatisGenertor自动生成DAO/Model/Mapper映射文件,提供了动态sql查询和分页功能以及多数据源的配置

> ### 前端页面框架-页面效果部分

- metronic4.7 前台和后台页面模板引擎

Maven启动Tomcat7插件的命令(可启动多个tomcat):

- mvn tomcat7:run -Dmaven.tomcat.port=8081 -Dmaven.tomcat.ajp.port=8010

### 基础使用流程

- 导入数据库 数据库位于 src/main/resources下 是finalssm.sql和finalssmData.sql
- 用代码生成数据库 入口位于: src/test/java/org.mybatis.generator/**DataPopulator.java**
- 利用MabatisGenerator生成DAO/Model/Mapper映射文件 入口位于:src/test/java/org.mybatis.generator/**MybatisGenerator.java**
- 如果自己有新的数据库结构 利用src/test/java/xml/XmlParseUtilsTest.java 生成新的配置文件
- 再运行MybatisGenerator.java

### Redis使用流程

- 解压redis-latest.zip到 **%REDIS%** 目录

- 我当前redis的密码设置为空  如果需要自己设置修改如下:

  - 工程配置文件位于: src/main/resources/redis.propeties

    ```
    #redis config
    redis.pass=
    redis.pool.maxTotal=105
    redis.pool.maxIdle=10
    redis.pool.maxWaitMillis=5000
    redis.pool.testOnBorrow=true

    #redis 端口号
    redis.ip=127.0.0.1
    redis.port=6379
    ```

  - Redis配置文件位于:**%REDIS%**/redis.windows.conf

  - 启动redis

    ```
    cd %REDIS%
    redis-server.exe redis.windows.conf
    ```

    ​

  ### ThymeLeaf模板引擎

  - 你们可以改成jsp的实现方式

###**架构图：**
![](http://i.imgur.com/vc6iu0X.png)