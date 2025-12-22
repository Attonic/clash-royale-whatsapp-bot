FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

WORKDIR /app

# Copia tudo e compila
COPY . .
RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# usuário seguro
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]