FROM openjdk:17-jdk

LABEL authors="luibov"

ARG JAR_FILE=target/*.jar

COPY ./target/School.jar .

ENTRYPOINT ["java","-jar","School.jar"]