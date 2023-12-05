package com.abt.ex5.agents;

import com.abt.ex5.meals.CookRecipe;
import com.abt.ex5.meals.Ingredient;
import com.abt.ex5.meals.RecipesDB;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

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

        this.addBehaviour(new SimpleBehaviour() {
            private final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);

            @Override
            public void action() {
                doWait();

                ACLMessage message = myAgent.receive(mt);

                if (message == null) {
                    System.out.println("Recepie name not received!");
                    this.block();
                    return;
                }

                CookRecipe recipe = findRecipe(message.getContent());

                if (recipe == null) {
                    System.out.println("Sorry no such meal in our menu.");
                    return;
                }

                printOutRecipe(recipe);
            }

            @Override
            public boolean done() {
                return true;
            }
        });
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

    public CookRecipe findRecipe(String recipeName) {

        return RecipesDB.getAll().stream()
                .filter(r -> recipeName.toLowerCase().equals(r.getName().toLowerCase()))
                .findAny()
                .orElse(null);
    }

    public void printOutRecipe(CookRecipe recipe) {
        System.out.println("\n------------------------");
        System.out.println("\t" + recipe.getName());
        System.out.println("------------------------");

        System.out.println("\nIngredients:");
        for (Ingredient ingredient : recipe.getIngredients()) {
            System.out.println(" " + ingredient);
        }

        System.out.println("\nInstructions:");
        for (String instruction : recipe.getInstructions()) {
            System.out.println(" " + instruction);
        }
    }
}
