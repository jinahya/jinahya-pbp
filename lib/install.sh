#!/bin/sh
mvn install:install-file\
    -Dfile=pbp_1.1.jar\
    -DgroupId=system\
    -DartifactId=pbp\
    -Dversion=1.1\
    -Dpackaging=jar\
    -DgeneratePom=true
