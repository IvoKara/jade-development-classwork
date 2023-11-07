package com.abt.ex3;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class CyclicAgent extends Agent {

    private final class CyclicBehaviourExtension extends CyclicBehaviour {
        private int round = 0;

        public CyclicBehaviourExtension(Agent agent) {
            super(agent);
        }

        @Override
        public void action() {
            System.out.println("Round: " + round++);

            if (round > 20) {
                CyclicAgent.this.doDelete();
            }
        }
    }

    @Override
    protected void setup() {
        this.addBehaviour(new CyclicBehaviourExtension(this));
    }

    @Override
    protected void takeDown() {
        System.out.println("Agent " + getAID().getName() + " terminated.");
    }
}
