package com.abt.ex1;

import jade.core.Agent;
import jade.core.Location;

public class AppAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("----------ABOUT ME----------");
        System.out.println("My local name is: " + this.getLocalName());
        System.out.println("My global unique name is " + this.getName());

        Location location = this.here();

        System.out.println("----------ABOUT HERE----------");
        System.out.println("I'm running in location called: " + location.getName());
        System.out.println("Identified as: " + location.getID());
        System.out.println("Contactable at: " + location.getAddress());
        System.out.println("Protocol: " + location.getProtocol());
    }
}
