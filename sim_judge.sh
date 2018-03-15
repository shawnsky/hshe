#!/bin/bash
EXE_PATH=/usr/local/sim302/bin
SUBS_PATH=/data/subs
EXT=$1
PROBLEM_ID=$2
SUBMISSION_ID1=$3
SUBMISSION_ID2=$4
result=`$EXE_PATH/sim_$EXT -p $SUBS_PATH/$PROBLEM_ID/$SUBMISSION_ID1/Main.$EXT $SUBS_PATH/$PROBLEM_ID/$SUBMISSION_ID2/Main.$EXT`
echo $result | egrep -o '[[:digit:]]+[[:space:]]+%' | egrep -o '[[:digit:]]+'
