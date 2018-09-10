package com.min.pattern.chain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.stereotype.Service;

@Service
public class ConcreteChainHandler implements ChainHandler {
	private ExecuteChain chain;

	{
		List<Node<Command>> list = new ArrayList<Node<Command>>();

		Reflections reflections = new Reflections("com.min.pattern.chain");
		Set<Class<? extends Node>> subTypes = reflections.getSubTypesOf(Node.class);
		for (Class<? extends Node> klass : subTypes) {
			Node<Command> node = SpringContextUtil.getBean(klass);
			list.add(node);
		}

		chain = new ExecuteChain(list);
	}

	public boolean executeChain(Command command) {
		return chain.executeChain(command, chain);
	}

}
