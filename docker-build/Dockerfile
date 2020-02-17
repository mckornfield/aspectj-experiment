from tomcat-base

# TODO: this file is not yet used, instead we are building using "docker run" because this mvn install takes forever
# due to no .m2 cache.  Could maybe create another image with .m2 cache and build from there, but it's easier to just
# mount the user's home dir as cache and build
# TODO: do we really want to build from /target?  Would that make /target/target?
COPY . /target
WORKDIR /target
RUN mvn install && mv /root/.m2/repository/ServletFilterExample/ServletFilterExample/1.0-SNAPSHOT/ServletFilterExample-1.0-SNAPSHOT.war $CATALINA_HOME/webapps/ServletFilterExample.war
