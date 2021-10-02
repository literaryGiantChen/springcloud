# 父工程pom文件依赖项

    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        
        <modelVersion>4.0.0</modelVersion>
    
        <groupId>com.atguigu.springcloud</groupId>
        <artifactId>mscloud03</artifactId>
        <version>1.0-SNAPSHOT</version>
        <packaging>pom</packaging>
        
        <!-- 统一管理jar包版本 -->
        <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            <maven.compiler.source>1.8</maven.compiler.source>
            <maven.compiler.target>1.8</maven.compiler.target>
            <junit.version>4.12</junit.version>
            <log4j.version>1.2.17</log4j.version>
            <lombok.version>1.16.18</lombok.version>
            <mysql.version>5.1.47</mysql.version>
            <druid.version>1.1.16</druid.version>
            <mybatis.spring.boot.version>1.3.0</mybatis.spring.boot.version>
        </properties>
        
        <!-- 子模块继承之后，提供作用：锁定版本+子modlue不用写groupId和version  -->
        <!-- 
               dependencyManagement里只是声明依赖，并不实现引入，因此子项目需要显示的声明需要用的依赖。
               如果不在子项目中声明依赖，是不会从父项目中继承下来的；只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承该项，并且version和scope都读取自父pom;
               如果子项目中指定了版本号，那么会使用子项目中指定的jar版本。 
             dependencyManagement（声明同一版本号） 和 dependencies（引用）的 子类向上引用，父类没有使用自己的 
        -->
        <dependencyManagement>
            <dependencies>
                <!--spring boot 2.2.2-->
                <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.2.2.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
                </dependency>
                <!--spring com.diu.cloud Hoxton.SR1-->
                <dependency>
                <groupId>org.springframework.com.diu.cloud</groupId>
                <artifactId>spring-com.diu.cloud-dependencies</artifactId>
                <version>Hoxton.SR1</version>
                <type>pom</type>
                <scope>import</scope>
                </dependency>
                <!--spring com.diu.cloud alibaba 2.1.0.RELEASE-->
                <dependency>
                <groupId>com.alibaba.com.diu.cloud</groupId>
                <artifactId>spring-com.diu.cloud-alibaba-dependencies</artifactId>
                <version>2.1.0.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
                </dependency>
                <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
                </dependency>
                <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
                </dependency>
                <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>${mybatis.spring.boot.version}</version>
                </dependency>
                <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>${junit.version}</version>
                </dependency>
                <dependency>
                    <groupId>log4j</groupId>
                    <artifactId>log4j</artifactId>
                    <version>${log4j.version}</version>
                </dependency>
                <dependency>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                    <version>${lombok.version}</version>
                    <optional>true</optional>
                </dependency>
            </dependencies>
        </dependencyManagement>
        
        <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <configuration>
                        <fork>true</fork>
                        <addResources>true</addResources>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    
    </project>

# Springboot中Plugin ‘org.springframework.boot:spring-boot-maven-plugin:‘ not found

解决方法

    定义统一使用的版本，引用即可
    <properties>
        <spring-boot-maven-plugin.version>2.5.3</spring-boot-maven-plugin.version>
    </properties>
    
    引用
    <version>${spring-boot-maven-plugin.version}</version>