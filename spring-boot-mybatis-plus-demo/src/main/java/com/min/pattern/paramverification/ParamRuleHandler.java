package com.min.pattern.paramverification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParamRuleHandler implements RuleHandler{

	@Autowired
	private VerificationParser<Rule> parser;
	
	/**
	 * 将解析出来的Rule存放在redis
	 */
	public void handle() {
		try {
			// 决定什么时候进行触发的
			/*
			 *  项目启动的时候进行处理
			 *  
			 */ 
		   List<Rule> rules= parser.parse(new FileInputStream(new File("")));
			// 将解析出来的规则存放在redis
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
