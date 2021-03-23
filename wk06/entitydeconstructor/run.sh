#!/bin/bash
jar=target/deconstructorgenerator.jar
if [ ! -e ${jar} ]; then mvn package; fi
java -jar ${jar} "$@"
