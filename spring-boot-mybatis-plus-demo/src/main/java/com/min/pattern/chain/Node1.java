package com.min.pattern.chain;

public class Node1 implements Node<Command> {
	public boolean execute(Command command, ExecuteChain chain) {
		if (command instanceof N1Command) {
			System.out.println("Node1");
			return true;
		} else {
			return chain.executeChain(command, chain);
		}
	}
}
