#!/bin/sh

THIS_DIR=$(dirname "$(readlink -f "$0")")""

cd $THIS_DIR

docker-compose kill
docker-compose rm --force

cd -

