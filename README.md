BeNeutral
================
[![CircleCI](https://circleci.com/gh/mariha/be-neutral.svg?style=shield&circle-token=54788ca69527fe3e9a550d3cf749c57ed96f5200)](https://circleci.com/gh/mariha/be-neutral)

A tool to calculate CO2 emitted by a house, advise how to reduce it, and encourages to offset the rest by planting trees.

http://www.beNeutral.eu

Community
------------------

To ask questions regarding contributing, share thoughts, feedback or really anything project related, please [join us on Slack](https://join.slack.com/t/co2-neutral/shared_invite/zt-h6klbvbo-8lifcdKDnr7ysmycG9TuJw) or during our [virtual office hours on Zoom](https://calendar.google.com/calendar/embed?src=uhc6qd6itv1789615oq29c2k98%40group.calendar.google.com&ctz=America%2FChicago).

How to start the BeNeutral application
-------------------------

1. You will need IBM Cloudant database credentials. The app config file expects them as the environment variables.
   ```
    export IBM_DB_URL=your-cloudant-db-url
    export IBM_IAM_KEY=your-ibm-iam-key
   ```
1. To run the application, you can either build and run it in your env or run it in a container. Either way, the BeNeutral banner in the log indicates the server is up.
    * Un-containerized app server
        1. Run `mvn package` to build the application
        1. Start application with `java -jar target/be-neutral-1.0-SNAPSHOT.jar server config.yml`
    * Run the server in a docker container, using the latest image from the master branch, published to dockerhub: \
        `docker run -p 8080:8080 -p 8081:8081 -e IBM_IAM_KEY -e IBM_DB_URL marihak/be-neutral`

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
