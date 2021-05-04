FROM maven:3-jdk-8 as builder
LABEL maintainer="https://github.com/shawnsky"

COPY ../core /src
WORKDIR /src/core

# optional
RUN sed -i 's/archive.ubuntu.com/mirrors.ustc.edu.cn/g' /etc/apt/sources.list

RUN apt-get update \
    && apt-get install -y build-essential \
    && mvn clean package -DskipTests

################################

FROM openjdk:8-jdk-buster
LABEL maintainer="https://github.com/shawnsky"

COPY ../wait-for-it.sh /app
COPY --from=builder /src/core/target/core-0.0.1-SNAPSHOT.jar /app/core.jar
WORKDIR /app
EXPOSE 9000

CMD wait-for-it.sh ${DB_HOST}:3306 -- echo 'MySQL is active.' && java -jar core.jar