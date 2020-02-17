#!/usr/bin/env bash

# TODO: this should do the docker build and run docker container
docker build . -t aspectj-experiment
# TODO: run these mvn commands in container with "docker run" (delegated mount) and then mount results (delegated)
mvn install
cp /Users/kevin.page/.m2/repository/ServletFilterExmaple/ServletFilterExmaple/1.0-SNAPSHOT/ServletFilterExmaple-1.0-SNAPSHOT.war ./tomcat/webapps/ServletFilterExmaple.war
