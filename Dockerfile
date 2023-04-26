FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /opt/app

COPY ./todoapi/.mvn/ .mvn
COPY ./todoapi/mvnw ./todoapi/pom.xml ./

RUN ./mvnw dependency:go-offline

COPY ./todoapi/src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT [ "java", "-jar", "/opt/app/*.jar" ]