FROM maven:3-jdk-8 as builder
LABEL maintainer="https://github.com/shawnsky"

COPY sim /src/sim
WORKDIR /src/sim

# optional
RUN sed -i 's/archive.ubuntu.com/mirrors.ustc.edu.cn/g' /etc/apt/sources.list

RUN apt-get update \
    && apt-get install -y build-essential \
    && mvn clean package -DskipTests

################################

FROM openjdk:8-jdk-buster
LABEL maintainer="https://github.com/shawnsky"

RUN mkdir /app
WORKDIR /app

COPY docker/wait-for-it.sh .
COPY docker/sim/sim302 /usr/local
COPY docker/sim/sim_judge.sh /usr/local/bin/
COPY --from=builder /src/sim/target/sim-0.0.1-SNAPSHOT.jar .

EXPOSE 9002

CMD ./wait-for-it.sh ${DB_HOST}:3306 -- echo 'MySQL is active.' && java -jar sim-0.0.1-SNAPSHOT.jar