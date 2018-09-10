package com.min.pattern.chain;

import java.util.List;

/**
 * 通过执行链来存放这些节点
 * @author PENGZHIGANG
 *
 */
public class ExecuteChain {
	
	private int index = 0;
	
	private List<Node<Command>> nodes;
	
	public ExecuteChain(List<Node<Command>> nodes){
        this.nodes = nodes;
    }
	
	public boolean executeChain(Command command,ExecuteChain chain){
		if (index >= nodes.size()) {
			return false;
		}
		
		return nodes.get(index++).execute(command, chain);
	}
	
}
