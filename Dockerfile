
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml .
COPY src src
RUN mvn -q -DskipTests package

FROM payara/server-full:6.2024.10-jdk17
USER root
COPY --from=build /workspace/target/ROOT.war $DEPLOY_DIR/ROOT.war
USER payara
EXPOSE 8080 4848
