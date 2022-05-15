FROM openjdk:18-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE_DEPENDENCIES=target/*-with-dependencies.jar
COPY ${JAR_FILE_DEPENDENCIES} dependencies.jar
ARG JAR_FILE=target/*-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-cp","app.jar", "com.willypuzzle.todospringapplication.ToDoSpringApplication"]