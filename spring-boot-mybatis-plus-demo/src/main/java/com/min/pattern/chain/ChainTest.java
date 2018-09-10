package com.min.pattern.chain;

public class ChainTest {
	public static void main(String[] args) {
		ConcreteChainHandler concreteChainHandler = new ConcreteChainHandler();
		concreteChainHandler.executeChain(new N2Command());
	}
}
