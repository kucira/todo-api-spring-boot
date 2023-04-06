FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /opt/app

COPY .mvn/ .mvn
COPY mvnmw pom.xml ./

RUN ./mvnm dependency:go-offline

COPY ./src ./src
RUN ./mvnmw clean install

FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT [ "java", "-jar", "/opt/app/*.jar" ]