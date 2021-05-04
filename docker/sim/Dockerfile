FROM maven:3-jdk-8 as builder
LABEL maintainer="https://github.com/shawnsky"

COPY ../sim /src
WORKDIR /src/sim

# optional
RUN sed -i 's/archive.ubuntu.com/mirrors.ustc.edu.cn/g' /etc/apt/sources.list

RUN apt-get update \
    && apt-get install -y build-essential \
    && mvn clean package -DskipTests

################################

FROM openjdk:8-jdk-buster
LABEL maintainer="https://github.com/shawnsky"

COPY ../wait-for-it.sh /app
COPY sim302 /usr/local
COPY sim_judge.sh /usr/local/bin/
COPY --from=builder /src/sim/target/sim-0.0.1-SNAPSHOT.jar /app/sim.jar
WORKDIR /app
EXPOSE 9002

CMD wait-for-it.sh ${DB_HOST}:${DB_PORT} -- echo 'MySQL is active.' && java -jar sim.jar