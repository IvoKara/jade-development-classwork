package com.abt.ex4;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiverAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("My name is " + this.getLocalName() + ".");

        this.addBehaviour(new Behaviour() {
            private final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);

            @Override
            public void action() {
                ACLMessage message = myAgent.receive(mt);

                if (message == null)
                    this.block();

                System.out.println(myAgent.getLocalName()
                        + ": I received a message.\n"
                        + message);
            }

            @Override
            public boolean done() {
                return false;
            }
        });
    }

}
