[![CircleCI](https://circleci.com/gh/mariha/household-footprint.svg?style=svg&circle-token=54788ca69527fe3e9a550d3cf749c57ed96f5200)](https://circleci.com/gh/mariha/household-footprint)

Household Footprint
================

A platform to calculate CO2 emitted by a household, advice how to reduce it, and encourages to offset the rest by planting trees.

How to start the Household Footprint application
-------------------------

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/household-footprint-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
-------------------

To see your applications health enter url `http://localhost:8081/healthcheck`
