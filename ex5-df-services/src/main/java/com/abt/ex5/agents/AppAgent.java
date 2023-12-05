package com.abt.ex5.agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AppAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("Hello world! My name is " + this.getLocalName() + ".");

        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setType("buyer");
        serviceDescription.setName(this.getLocalName());

        DFAgentDescription dfDescription = new DFAgentDescription();
        dfDescription.setName(this.getAID());
        dfDescription.addServices(serviceDescription);

        try {
            DFService.register(this, dfDescription);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
    }

    @Override
    protected void takeDown() {
        super.takeDown();

        try {
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
    }
}
