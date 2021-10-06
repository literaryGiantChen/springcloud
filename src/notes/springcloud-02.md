cmd# com.diu.cloud-provider-payment8001

# 第一

    创建cloud-provider-payment8001子maven工程

# 第二 引入依赖

    版本号会先从父类寻找，其次就是子类寻找

    <dependencies>
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.1.10</version>
        </dependency>
        <!--mysql-connector-java-->
        <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--jdbc-->
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
        </dependency>
        <dependency>
        <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
        <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

# 第三 #yml项

    server:
    port:8001
    
    spring:
    application:
    name:com.diu.cloud-payment-service
    datasource:
    type:com.alibaba.druid.pool.DruidDataSource # 当前数据源操作类型
    driver-class-name:org.gjt.mm.mysql.Driver # mysql驱动包com.mysql.jdbc.Driver
    url:jdbc:mysql://localhost:3306/db2019?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username:root
    password:123456
    
    
    mybatis:
    mapperLocations:classpath:mapper/*.xml
    type-aliases-package:com.atguigu.springcloud.entities #所有Entity别名类所在包

# 端口号为占用了

Web server failed to start. Port 8001 was already in use.

    打开 cmd 
        1：输入：netstat -ano
            在本地地址找到项目的端口号，记录PID的号码，最后一串数字。
        2：输入：taskkill /F /pid 号码
        3：启动项目