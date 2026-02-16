FROM eclipse-temurin:21-jre-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} devops-application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/devops-application.jar"]