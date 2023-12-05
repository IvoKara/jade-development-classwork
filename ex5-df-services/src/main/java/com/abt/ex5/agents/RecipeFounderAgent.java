package com.abt.ex5.agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class RecipeFounderAgent extends Agent {

    @Override
    protected void setup() {
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setType(AgentTypes.RECIPE_FOUNDER);
        serviceDescription.setName(this.getLocalName());

        DFAgentDescription dfDescription = new DFAgentDescription();
        dfDescription.setName(this.getAID());
        dfDescription.addServices(serviceDescription);

        try {
            DFService.register(this, dfDescription);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        // this.registerDFService();
    }

    private void registerDFService() {

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
