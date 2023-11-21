# Exercise 1: Get familiar with JADE and agent-based architecture

To see that the class task is accomplished type in terminal:
```sh
mvn -Pjade exec:java
```

## Notes for Eclipse
In order to run it in **Eclipse** you should create New Run Configuration as 
**_Maven Build_**.

Then in "_Goals:_" field paste the above shell command without the `mvn` key, i.e.:
```
-Pjade exec:java
```