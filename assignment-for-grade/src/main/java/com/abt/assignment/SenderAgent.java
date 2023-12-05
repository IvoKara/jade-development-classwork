package com.abt.assignment;

import java.util.Arrays;
import java.util.stream.Collectors;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class SenderAgent extends Agent {

    @Override
    protected void setup() {

        this.addBehaviour(new SimpleBehaviour() {
            @Override
            public void action() {
                // System.out.println("What are your numbers?");
                // System.out.print("Numbers: ");

                // Scanner in = new Scanner(System.in);
                // String order = in.nextLine();
                // in.close();

                // this.block(50_000);

                int[] numbers = new int[] { 2, 4, 6, 8 };
                sendNumbers(numbers);
            }

            @Override
            public boolean done() {
                return true;
            }
        });
    }

    private void sendNumbers(int[] numbers) {
        AID receiver = new AID("Receiver", AID.ISLOCALNAME);
        ACLMessage message = new ACLMessage(ACLMessage.REQUEST);

        message.addReceiver(receiver);

        String content = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

        message.setContent(content);

        this.send(message);
    }
}
