./build.sh

See glowroot:
http://localhost:4000/

Hit sample echo servlet:
http://localhost:8080/ServletFilterExample/echo

Hitting this will also insert a test value into RDBMS.  Database: Test, Table: TEST

Web console for sample DB:
http://localhost:8081/
(then just click Connect, default form values are fine)

Tomcat archive is checked in for convenience for this sample project and was downloaded from:
https://www.apache.org/dist/tomcat/tomcat-$TOMCAT_MAJOR/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz