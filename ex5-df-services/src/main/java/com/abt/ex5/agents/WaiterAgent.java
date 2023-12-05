package com.abt.ex5.agents;

import java.util.Scanner;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

import jade.lang.acl.ACLMessage;

public class WaiterAgent extends Agent {

    private AID receiver;

    @Override
    protected void setup() {
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setType(AgentTypes.RECIPE_FOUNDER);

        DFAgentDescription dfDescription = new DFAgentDescription();
        dfDescription.addServices(serviceDescription);

        try {
            DFAgentDescription[] results = DFService.search(this, dfDescription);

            if (results.length > 0)
                this.receiver = results[0].getName();

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.addBehaviour(new Behaviour() {
            @Override
            public void action() {
                System.out.println("What is your order?");
                System.out.print("Answer: ");

                Scanner in = new Scanner(System.in);
                String order = in.nextLine();
                in.close();

                this.block(50_000);
                sendMessage(order);
            }

            @Override
            public boolean done() {
                return false;
            }
        });
    }

    private void sendMessage(String content) {
        ACLMessage message = new ACLMessage(ACLMessage.REQUEST);

        message.addReceiver(this.receiver);
        message.setContent(content);

        this.send(message);
    }
}
