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
- 统一的异常处理
- JSP JSTL JavaScript
- Sping Shiro权限控制（待完善）
- Thymeleaf模板引擎
- Springside4工具包/ApacheCommons/Guava工具包

> ### 前端页面框架-

- metronic4.7

Maven启动Tomcat7插件的命令(可启动多个tomcat):

- mvn tomcat7:run -Dmaven.tomcat.port=8081 -Dmaven.tomcat.ajp.port=8010

> Redis使用

- ​

###**架构图：**
![](http://i.imgur.com/vc6iu0X.png)