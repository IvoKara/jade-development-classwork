package com.abt.ex3;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

public class AppAgent extends Agent {

    @Override
    protected void setup() {
        this.addBehaviour(new SimpleBehaviour(this) {
            private boolean finished = true;
            private int round = 0;

            @Override
            public void action() {
                System.out.println("Inside Action:: " + round++);
            }

            @Override
            public boolean done() {
                return finished;
            }
        });
    }
}
