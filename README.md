BeNeutral
================
[![CircleCI](https://circleci.com/gh/mariha/be-neutral.svg?style=shield&circle-token=54788ca69527fe3e9a550d3cf749c57ed96f5200)](https://circleci.com/gh/mariha/be-neutral)

A tool to calculate CO2 emitted by a house, advise how to reduce it, and encourages to offset the rest by planting trees.

The project is temporarily hosted under: http://www.beNeutral.wanderers.pl/

How to start the BeNeutral application
-------------------------

1. You will need IBM Cloudant database credentials. \
    `export IBM_DB_URL=your-cloudant-db-url` \
    `export IBM_IAM_KEY=your-ibm-iam-key` \
    alternatively, put your url and iamKey directly in `/config.yml` and `/src/test/resources/test-config.yml` 
    
1. To run the application, you can either build and run it in your env or run it in a container. Either way, the BeNeutral banner in the log indicates the server is up.
    * Un-containerized app server
        1. Run `mvn package` to build the application
        1. Start application with `java -jar target/be-neutral-1.0-SNAPSHOT.jar server config.yml`
    * Run the server in a docker container, using the latest image from the master branch, published to dockerhub: \
        `docker run -p 8080:8080 -p 8081:8081 marihak/be-neutral`

1. To check that the application is running enter url `http://localhost:8080/api/v1/`
1. You can find api documentation at `http://localhost:8080/api/v1/swagger`
1. The front page can be found under `http://localhost:8080/`

Health Check
-------------------

To see your applications health enter url `http://localhost:8081/healthcheck`

Tests
-------------
- `mvn test` - runs unit tests
- `mvn verify` - runs unit and integration tests
- `mvn clean package -DskipTests` - re-builds without tests