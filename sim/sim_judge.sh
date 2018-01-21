#!/bin/bash
EXE_PATH=/usr/local/sim302/bin
SUBS_PATH=/data/subs
EXT=$1
PROBLEM_ID=$2
STU1=$3
STU2=$4
result=`$EXE_PATH/sim_$EXT -p $SUBS_PATH/$PROBLEM_ID/$STU1.$EXT $SUBS_PATH/$PROBLEM_ID/$STU2.$EXT`
echo $result | egrep -o '[[:digit:]]+[[:space:]]+%' | egrep -o '[[:digit:]]+'
