FROM openjdk:11-jre

LABEL maintainer "Maria Kozinska m.kozinska@gmail.com"

COPY ./target/be-neutral-*-SNAPSHOT.jar beNeutral.jar
COPY ./config.yml config.yml

EXPOSE 8080 8081
ENTRYPOINT ["java", "-jar", "/beNeutral.jar", "server", "/config.yml"]
