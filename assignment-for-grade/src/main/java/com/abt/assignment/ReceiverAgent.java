package com.abt.assignment;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiverAgent extends Agent {

    @Override
    protected void setup() {
        this.addBehaviour(new AverageBehaviour(this));
    }

    class AverageBehaviour extends SimpleBehaviour {
        private final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);

        public AverageBehaviour(Agent agent) {
            super(agent);
        }

        @Override
        public void action() {
            myAgent.doWait();

            ACLMessage message = myAgent.receive(mt);

            if (message == null) {
                System.out.println("Numbers not received.");
                System.out.println("Aborting.");
                this.block();
                return;
            }

            System.out.println("Received: " + message.getContent());

            int[] numbers = convertToIntArray(message.getContent());
            float average = calculateAverage(numbers);

            System.out.println("Average: " + average);
        }

        @Override
        public boolean done() {
            return true;
        }
    }

    public int[] convertToIntArray(String content) {
        String[] numberStrs = content.split(",");

        int[] numbers = new int[numberStrs.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberStrs[i]);
        }

        return numbers;
    }

    public float calculateAverage(int[] numbers) {
        float sum = 0;

        int i = 0;
        while (i < numbers.length) {
            sum += numbers[i];
            i++;
        }

        float average = sum / numbers.length;
        return average;
    }
}
