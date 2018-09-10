package com.min.pattern.chain;
/**
 * 初始化执行链
 * 通过反射拿到所有指定包下的Node
 * @author PENGZHIGANG
 *
 */
public interface ChainHandler {
	
	boolean executeChain(Command command);
}
