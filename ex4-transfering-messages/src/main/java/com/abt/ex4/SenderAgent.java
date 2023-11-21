package com.abt.ex4;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;;

public class SenderAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("My name is " + this.getLocalName() + ".");
        sendMessage();
    }

    private void sendMessage() {
        AID receiver = new AID("Peter", AID.ISLOCALNAME);
        ACLMessage message = new ACLMessage(ACLMessage.REQUEST);

        message.addReceiver(receiver);
        message.setContent("Hello, how are you?");

        this.send(message);
    }
}
