package com.min.pattern.chain;

public interface Node<T extends Command> {
	
	 boolean execute(T command, ExecuteChain chain);
}
