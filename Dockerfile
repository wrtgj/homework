# 基础镜像，使用OpenJDK 17
#FROM openjdk:17-jdk-slim
FROM openjdk:17
#FROM openjdk:17-jdk-alpine
# 设置工作目录
WORKDIR //Users/lishuangquan/Documents/app

# 将本地的JAR文件复制到容器的工作目录
COPY target/antiFraud-0.0.1-SNAPSHOT.jar /Users/lishuangquan/Documents/app/antiFraud-0.0.1-SNAPSHOT.jar

# 暴露应用的端口（假设Spring Boot应用使用8080端口）
EXPOSE 8080

# 定义容器启动时执行的命令
CMD ["java","-jar","antiFraud-0.0.1-SNAPSHOT.jar"]
