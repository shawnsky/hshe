FROM maven:3-jdk-8 as builder
LABEL maintainer="https://github.com/shawnsky"

COPY ../judge /src
WORKDIR /src/judge

# optional
RUN sed -i 's/archive.ubuntu.com/mirrors.ustc.edu.cn/g' /etc/apt/sources.list

RUN apt-get update \
    && apt-get install -y build-essential \
    && mvn clean package -DskipTests

################################

FROM openjdk:8-jdk-buster
LABEL maintainer="https://github.com/shawnsky"

# RUN sed -i 's/archive.ubuntu.com/mirrors.ustc.edu.cn/g' /etc/apt/sources.list \
#     && apt-get update \
#     && apt-get install -y openjdk-8-jdk mysql-client \
#     && apt-get clean \
#     && rm -rf \
#       /tmp/* \
#       /usr/share/doc/* \
#       /var/cache/* \
#       /var/lib/apt/lists/* \
#       /var/tmp/* \
#     && useradd hshe -u 1000 -p "$(openssl passwd -1 hshepasswd)" \
#     && chown -R 1000:1000 /data/subs/ /data/tests/ \
#     && rm -rf /data/subs/* /data/tests/*
  

RUN useradd hshe -u 1000 -p "$(openssl passwd -1 hshepasswd)" \
    && chown -R 1000:1000 /data/subs/ /data/tests/ \
    && rm -rf /data/subs/* /data/tests/*

COPY ../wait-for-it.sh /app
COPY --from=builder /src/judge/target/judge-0.0.1-SNAPSHOT.jar /app/judge.jar
WORKDIR /app
EXPOSE 9001

CMD wait-for-it.sh ${DB_HOST}:${DB_PORT} -- echo 'MySQL is active.' && su hshe --command "java -jar judge.jar"









