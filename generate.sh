#!/bin/bash

mvn archetype:generate                              \
  -DarchetypeGroupId=com.archetype.jade             \
  -DarchetypeArtifactId=jade-archetype-quickstart   \
  -DarchetypeVersion=1.0-SNAPSHOT                   \
  -DgroupId=$1                                      \
  -DartifactId=$2                                   \
  -DinteractiveMode=false
