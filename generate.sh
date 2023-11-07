#!/bin/sh

SHORT="g:a:"
LONG="groupId:,group-id:,artifactId:,artifact-id"
OPTIONS=$(getopt --options $SHORT --long $LONG --name="$0" -- "$@")

if [ $? != "0" ]; then
    echo "Failed to parse options...exiting."
    exit 1
fi

eval set -- "$OPTIONS"

while :; do
    case "$1" in
    -g | --groupId | --group-id)
        GROUP_ID="$2"
        shift 2
        ;;
    -a | --artifactId | --artifact-id)
        ARTIFACT_ID="$2"
        shift 2
        ;;
    --)
        shift
        break
        ;;
    *)
        echo "Unexpected option $1"
        ;;
    esac
done

mvn archetype:generate                              \
  -DarchetypeGroupId=com.archetype.jade             \
  -DarchetypeArtifactId=jade-archetype-quickstart   \
  -DarchetypeVersion=1.0-SNAPSHOT                   \
  -DgroupId=$GROUP_ID                               \
  -DartifactId=$ARTIFACT_ID                         \
  -DinteractiveMode=false
