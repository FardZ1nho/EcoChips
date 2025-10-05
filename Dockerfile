# Etapa 1: Construcción del JAR con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen ligera con Java 17
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Arrancar Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
