# JADE development classwork
A repository containing a collection of Java projects that aimed to accomplish tasks from classwork exercises 🗒️.

All tasks for a given exercise are done in a separate project in order to maintain consistency and readability.

## More about Java Agent DEvelopment Framework (JADE)
...

## Things to note
...

## Steps to reproduce
In order to use the provided `jade-quickstart-archetype` you will need to
add it to the local maven archetype set. 

To do this an `install.sh` script is created for convenience. 
So it is only needed to run it:
```sh
./install.sh
```
Then you are able to use the archetype for building fresh new JADE-oriented starter projects.

This could be achieved with some sort of a complex and long command with the following signature:
```sh
mvn archetype:generate                              \
  -DarchetypeGroupId=com.archetype.jade             \
  -DarchetypeArtifactId=jade-archetype-quickstart   \
  -DarchetypeVersion=1.0-SNAPSHOT                   \
  -DgroupId=<my.project.groupId>                    \
  -DartifactId=<my-project-name>                    \
  -DinteractiveMode=false
```

And here you are already covered. With the `generate.sh` shell script it is easier to create a new project by 
just providing the `groupId` and the `arifactId` as arguments:
```sh
./generate.sh ...
```
