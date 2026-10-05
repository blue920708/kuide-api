FROM eclipse-temurin:17-jdk AS build

WORKDIR /workspace
COPY . .
RUN chmod +x gradlew && ./gradlew --no-daemon :tour-service:bootJar

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /workspace/tour-service/build/libs/tour-service.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
