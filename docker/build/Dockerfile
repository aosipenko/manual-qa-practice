FROM amazoncorretto:21-alpine

RUN mkdir -p /app/jar
WORKDIR /app/jar

COPY qa-automation-core-1.0.0-SNAPSHOT.jar my-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/jar/my-app.jar"]