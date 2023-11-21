# Exersice 3: Agent Behavours

In order to see the results from **Task 1**:
```sh
mvn -Pjade exec:java -Dexec.args="-agents Chief:restaurant.agents.MealAgent"
```

In order to see results from **Task 2**:
```sh
mvn -Pjade exec:java -Dexec.args="-agents Cyclic:com.abt.ex3.CyclicAgent"
```

## Notes for Eclipse
In order to run it in **Eclipse** you should create New Run Configuration as **_Maven Build_**.

Then in "_Goals:_" field paste the concrete shell command without the `mvn` key.

For **Task 1**:
```
-Pjade exec:java -Dexec.args="-agents Chief:restaurant.agents.MealAgent"
```

For **Task 2**:
```
-Pjade exec:java -Dexec.args="-agents Cyclic:com.abt.ex3.CyclicAgent"
```
