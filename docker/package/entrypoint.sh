#!/bin/bash

apt-get update > /dev/null
apt-get install -y build-essential > /dev/null

cd /src/core
mvn clean package -DskipTests
cp -f target/core-0.0.1-SNAPSHOT.jar /opt/core/core.jar
echo "package core done, ls docker/core"
ls /opt/core

cd /src/judge
mvn clean package -DskipTests
cp -f target/judge-0.0.1-SNAPSHOT.jar /opt/judge/judge.jar
echo "package judge done, ls docker/judge"
ls /opt/judge

cd /src/sim
mvn clean package -DskipTests
cp -f target/sim-0.0.1-SNAPSHOT.jar /opt/sim/sim.jar
echo "package sim done, ls docker/sim"
ls /opt/sim