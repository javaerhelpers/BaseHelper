### base基础包
——————————————提供基础方面的工具类，注解类
#### 说明文档目录：
#####     1.[使用方法](#一使用方法)
#####     2.[外部依赖jar包说明](#二外部依赖jar包说明)
#####     3.[版本说明](#三版本说明)
#### 一、使用方法
    1.jar包直接导入到项目里使用
    2.maven等项目版本依赖库加载
#### 二、外部依赖jar包说明
    依赖的jar包需要在项目中引用，否则会报错
##### 1.1 slf4j依赖 log专用：
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.25</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>1.7.25</version>
    </dependency>  
#### 三、版本说明
    本基础包版本1.0.0之前都是测试使用，如果想引用请高于1.0.0版本