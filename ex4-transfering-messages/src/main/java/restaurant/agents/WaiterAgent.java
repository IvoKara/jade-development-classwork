package restaurant.agents;

import java.util.Scanner;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class WaiterAgent extends Agent {

    @Override
    protected void setup() {

        this.addBehaviour(new Behaviour() {
            @Override
            public void action() {
                System.out.println("Hello I am " + WaiterAgent.this.getLocalName());
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
        AID receiver = new AID("Cooker", AID.ISLOCALNAME);
        ACLMessage message = new ACLMessage(ACLMessage.REQUEST);

        message.addReceiver(receiver);
        message.setContent(content);

        this.send(message);
    }
}
