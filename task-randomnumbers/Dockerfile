FROM eclipse-temurin:17-jdk as BUILD

ARG SPRING_PROFILES_ACTIVE=default

RUN mkdir -p /usr/src/app
COPY .mvn/ /usr/src/app/.mvn
COPY mvnw /usr/src/app 
COPY pom.xml /usr/src/app 

WORKDIR /usr/src/app

RUN ./mvnw dependency:go-offline

COPY . /usr/src/app 

RUN ./mvnw clean install -DskipTests


FROM eclipse-temurin:17-jre

COPY --from=BUILD /usr/src/app/target/*.jar /opt/target/app.jar

ENTRYPOINT ["java", "-jar", "/opt/target/app.jar"]