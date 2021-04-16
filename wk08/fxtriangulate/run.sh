#!/bin/bash

if [ ! -f target/image/bin/java ]; then
    mvn -P fx -Dexec.mainClass=fxtriangulate.App javafx:jlink
fi

target/image/bin/java -m fxtriangulate/fxtriangulate.App
# mvn -P fx -Dexec.mainClass=fxtriangulate.App javafx:run # 
