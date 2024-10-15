FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17.0.12_7-jre-noble
ENV WEATHER_API_KEY="ND2J8ZDV6UGND7FVN6HCXJHL7" REDIS_CONNECTION_STRING="redis:6379"
COPY --from=builder /app/target/weather-api-0.0.1-SNAPSHOT-jar-with-dependencies.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

