package com.min.pattern.chain;

import org.springframework.stereotype.Service;

@Service
public class N2Command implements Command {
	
	public boolean execute(Command command, ExecuteChain chain) {
        if(command instanceof N2Command){
            System.out.println("Node2");
            return true;
        } else {
            return chain.executeChain(command, chain);
        }
    }
}	
