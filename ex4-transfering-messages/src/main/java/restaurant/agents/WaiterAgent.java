package restaurant.agents;

import java.util.Scanner;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class WaiterAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("Hello I am " + this.getLocalName());
        // System.out.println("What is your order?");
        // System.out.print("Answer: ");

        // Scanner in = new Scanner(System.in);
        // String order = in.nextLine();
        // in.close();

        this.sendMessage("sushi");
    }

    private void sendMessage(String content) {
        AID receiver = new AID("Cooker", AID.ISLOCALNAME);
        ACLMessage message = new ACLMessage(ACLMessage.REQUEST);

        message.addReceiver(receiver);
        message.setContent(content);

        this.send(message);
    }
}
