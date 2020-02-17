#! /bin/sh

CATALINA_OPTS="$CATALINA_OPTS -javaagent:/glowroot/glowroot.jar"
#CATALINA_OPTS="$CATALINA_OPTS -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
#CATALINA_OPTS="$CATALINA_OPTS -verbose:class"
