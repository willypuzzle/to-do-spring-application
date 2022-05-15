FROM openjdk:18-jdk-alpine
COPY ./ ./
RUN chmod u+x ./mvnw
RUN ./mvnw package
RUN ./mvnw assembly:single
ARG JAR_FILE=target/*-dependencies.jar
RUN cp ${JAR_FILE} app.jar
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ENTRYPOINT ["java","-cp","app.jar", "com.willypuzzle.todospringapplication.ToDoSpringApplication"]