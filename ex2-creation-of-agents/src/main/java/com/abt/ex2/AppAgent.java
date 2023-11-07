package com.abt.ex2;

import jade.core.Agent;

public class AppAgent extends Agent {
    
    @Override
    protected void setup() {
        System.out.println("Hello world! My name is " + this.getLocalName() + ".");
    }
}
