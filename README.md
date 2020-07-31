BeNeutral
================
[![CircleCI](https://circleci.com/gh/mariha/be-neutral.svg?style=shield&circle-token=54788ca69527fe3e9a550d3cf749c57ed96f5200)](https://circleci.com/gh/mariha/be-neutral)

A tool to calculate CO2 emitted by a house, advise how to reduce it, and encourages to offset the rest by planting trees.

How to start the BeNeutral application
-------------------------

1. You will need IBM Cloudant database credentials. \
    Put your url and iamKey in `/config.yml` and `/src/test/resources/test-config.yml`
1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/be-neutral-1.0-SNAPSHOT.jar server config.yml` \
    Alternatively, you can build a docker image and run the API server in a container: \
    `docker build . -t be-neutral` \
    `docker run -p 8080:8080 -p 8081:8081 be-neutral`
1. To check that the application is running enter url `http://localhost:8080/api/v1/` \
    (wait for BeNeutral banner in the log)
1. You can find api documentation at `http://localhost:8080/api/v1/swagger`

Health Check
-------------------

To see your applications health enter url `http://localhost:8081/healthcheck`
