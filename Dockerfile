FROM eclipse-temurin:21-jre-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} my_app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/my_app.jar"]