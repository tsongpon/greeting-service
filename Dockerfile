FROM eclipse-temurin:21-jdk-alpine
COPY target/*.jar app.jar
COPY opentelemetry-javaagent.jar opentelemetry-javaagent.jar

EXPOSE 9002

ENTRYPOINT ["java", "-javaagent:/opentelemetry-javaagent.jar", "-jar","/app.jar"]