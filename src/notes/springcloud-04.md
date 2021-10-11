# zipkin

## 下载：

    https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/
    https://github.com/openzipkin/zipkin/tree/master/zipkin-server
    java -jar zipkin-server-2.23.4-exec.jar

# spring-cloud-alibaba

    https://spring.io/projects/spring-cloud-alibaba#learn

## nacos

    文档：https://nacos.io/zh-cn/docs/quick-start.html
    windows
        解压：unzip nacos-server-$version.zip
    
    linux nacos
        下载：wget https://github.com/alibaba/nacos/releases/download/2.0.3/nacos-server-2.0.3.tar.gz
        解压：tar -xvf nacos-server-$version.tar.gz
    
    启动命令(standalone代表着单机模式运行，非集群模式):
        startup.cmd -m standalone

    rem 集群配置：set MODE="cluster"
    rem 单机配置：set MODE="standalone"

    支持cp 和 ap 两种模型 (需要什么模型，会切换到适合的模型)
        AP模式为了服务的可能性而减弱了一致性，因此AP模式下只支持注册临时实例。
        CP模式下则支持注册持久化实例，此时则是以 Raft 协议为集群运行模式，该模式下注册实例之前必须先注册服务，如果服务不存在，则会返回错误。
    
    切换命令：curl -X PUT '$NACOS_SERVER:8848/nacos/v1/ns/operator/switches?entry=serverMode&value=CP'

# 连接mysql 数据库

    版本：5.6+
    执行自带的sql：nacos\conf\nacos-mysql.sql
    修改proerties：nacos\conf\application.properties
        配置文件末尾增加以下内容：

            spring.datasource.platform=mysql
    
            db.num=1
            #db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
            db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&serverTimezone=Asia/Shanghai&serverTimezone=GMT%2B8
            db.user=root
            db.password=123456
    
    执行启动命令时报错，查看日志：nacos\logs\nacos.log，开头就有答案