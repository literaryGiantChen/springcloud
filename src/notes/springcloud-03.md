# com.diu.cloud-consumer-order80

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

# com.diu.cloud-api-commons

    <dependencies>
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
        <groupId>cn.hutool</groupId>
        <artifactId>hutool-all</artifactId>
        <version>5.1.0</version>
        </dependency>
    </dependencies>

public CommonResult(Integer code, String message, T data)
{ this.code = code; this.message = message; this.data = data; } public CommonResult( Integer code,String message) {
this( code, message,null); }

public CommonResult(T data) { this(200, "操作成功", data); }

//setter--getter public T getData() { return data; }

public void setData(T data) { this.data = data; }

public String getMessage() { return message; }

public void setMessage(String message) { this.message = message; }

public Integer getCode() { return code; }

public void setCode(Integer code) { this.code = code; }