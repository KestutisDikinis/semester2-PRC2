@echo off
set jar=target/deconstructorgenerator.jar
if not exist %jar% cls & echo Maven... & call mvn package
echo.
java -jar %jar% %*
