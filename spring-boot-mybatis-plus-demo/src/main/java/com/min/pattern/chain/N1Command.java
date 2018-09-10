package com.min.pattern.chain;

import org.springframework.stereotype.Service;

@Service
public class N1Command implements Command{
	public boolean execute(Command command, ExecuteChain chain) {
        if(command instanceof N1Command){
            System.out.println("Node1");
            return true;
        } else  {
            return chain.executeChain(command, chain);
        }
    }
}
