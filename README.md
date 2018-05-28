# SBThymeleaf

#### 项目介绍

1. SpringBoot整合Mybatis + Thymeleaf示例
2. 继续整合分页插件PageHelper
3. 继续整合通用Mapper插件
4. Maven集成Mybatis Geneator
5. 集成Swagger，Swagger UI和Swagger UI Layer

#### 软件架构

1. SpringBoot + Thymeleaf + Mybatis + PageHelper + 通用Mapper + Swagger

#### 安装教程

1. 解压后执行src\main\resources\sql\MySQL.sql脚本创建数据库和表
2. 在pom.xml这一级目录(即项目根目录下)的命令行窗口执行```
                                 mvn mybatis-generator:generate
                                 ```(前提是配置了mvn)(IDEA可以直接在Maven窗口Plugins中双击执行)，创建Entity(Model)和Mapper后正常启动即可
3. 新增Swagger，因为Entity(Model)的有Swagger注解所以将Mybatis Geneator配置文件src\main\resources\generator\generatorConfig.xml中Entity(Model)的自动生成代码注释了
```
<!-- Model -->
<!--<javaModelGenerator targetPackage="com.wang.entity" targetProject="src/main/java"/>-->

<!-- Mapper XML -->
<sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources"/>

<!-- Mapper -->
<javaClientGenerator targetPackage="com.wang.mapper" targetProject="src/main/java"
                     type="XMLMAPPER"/>
```

#### 使用说明

1. SpringBoot整合系列
2. Swagger UI:[http://localhost:8080/swagger-ui.html/](http://localhost:8080/swagger-ui.html/)
3. Swagger UI Layer:[http://localhost:8080/docs.html/](http://localhost:8080/docs.html/)

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
