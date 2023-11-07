#!/bin/sh

help()
{
    echo
    echo "Simplified version of mvn generate with JADE framework in mind."
    echo
    echo "Usage:"
    echo "  generate.sh -g <group.id> -a <artifact-id>"
    echo "  generate.sh --groupId <group.id> --artifactId <artifact-id>"
    echo "  generate.sh --group-id=<group.id> -artifact-id=<artifact-id>"
    echo
    echo "Options:"
    echo "  -g, --groupId, --group-id          Maven's project group id."
    echo "  -a, --artifactId, --artifact-id    Maven's project artifact id."
    echo "  -h, --help                         Print this help."
    echo
}

SHORT="g:a:h"
LONG="groupId:,group-id:,artifactId:,artifact-id,help"
OPTIONS=$(getopt --options $SHORT --long $LONG --name="$0" -- "$@")

if [ $? != "0" ]; then
    echo "Failed to parse options...exiting."
    help
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
    -h | --help)
        help
        exit 0
        ;;
    --)
        shift
        break
        ;;
    *)
        echo "Unexpected option $1"
        help
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
