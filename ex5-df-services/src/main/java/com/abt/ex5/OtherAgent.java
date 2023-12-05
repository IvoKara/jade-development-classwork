package com.abt.ex5;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class OtherAgent extends Agent {

    @Override
    protected void setup() {
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setType("buyer");

        DFAgentDescription dfDescription = new DFAgentDescription();
        dfDescription.addServices(serviceDescription);

        try {
            DFAgentDescription[] results = DFService.search(this, dfDescription);

            for (DFAgentDescription res : results) {
                System.out.println(res.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
