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