#!/bin/bash
scriptdir=$(dirname $0)
classes=""
for c in $(find target/classes/ -name "*.class" | sed -e's#target/classes/##g;s#/#.#g;s#.class##') ; do
    classes="${classes} ${c}"
done

echo "classes $classes"
#mvn -q -DskipTests package
java -cp ${scriptdir}/target/genericmapper-2.0-SNAPSHOT.jar:target/classes genericmapper.MapperGenerator $(echo ${classes})
#     | tee target/generated-sources/generator/FieldPairMapper.java
#javac  -cp target/classes  target/generated-sources/generator/FieldPairMapper.java 
