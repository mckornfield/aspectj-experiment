#!/usr/bin/env bash

CATALINA_HOME="/usr/local/tomcat"

# Use separate build dir so docker context is not polluted with megabytes of expanded tomcat binaries
pushd docker-build
docker rmi tomcat-base
docker build -f Dockerfile-tomcat-base . -t tomcat-base
popd
docker run -it --rm -v "$PWD":/target:delegated -v ~/.m2:/root/.m2:delegated -w /target tomcat-base mvn clean install
docker run -it --rm -v "$PWD":/target:delegated -v "$PWD"/glowroot:/glowroot:delegated -v ~/.m2/repository/ServletFilterExample/ServletFilterExample/1.0-SNAPSHOT/ServletFilterExample-1.0-SNAPSHOT.war:$CATALINA_HOME/webapps/ServletFilterExample.war -p 8080:8080 -p 4000:4000 tomcat-base
