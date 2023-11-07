package com.abt.ex2;

import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

@SuppressWarnings("serial")
public class CreateAgent extends Agent {
	@Override
	protected void setup() {
		System.out.println("I am the creator and my name is " + this.getLocalName() + ".");

		String name = "Jerry";
		ContainerController contContr = this.getContainerController();
		try {
			AgentController agentContr = contContr.createNewAgent(name, "com.abt.ex2.AppAgent", null);
			agentContr.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
