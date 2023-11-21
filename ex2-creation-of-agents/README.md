# Exersice 2: Creating agents from other agents

In order to see results from **Task 1** type in console:
```sh
mvn -Pjade exec:java -Dexec.args="-agents Tom:com.abt.ex2.CreateAgent -gui"
```

**Task 2** and **Task 3** are related (**Task 2** should be done in order to start tinking on **Task 3**),
so for the end result type in console:
```sh
mvn -Pjade exec:java -Dexec.args="-agents Chief:restaurant.agents.MealAgent"
```

## Notes for Eclipse
In order to run it in **Eclipse** you should create New Run Configuration as 
**_Maven Build_**.

Then in "_Goals:_" field paste the concrete shell command without the `mvn` key.

For **Task 1**:
```
-Pjade exec:java -Dexec.args="-agents Tom:com.abt.ex2.CreateAgent -gui"
```

For **Task 2** and **Task 3**:
```
-Pjade exec:java -Dexec.args="-agents Chief:restaurant.agents.MealAgent"
```