package com.min.service;

import com.baomidou.mybatisplus.service.IService;
import com.min.entity.Book;

public interface BookService extends IService<Book>{
	      
	    public void addBook(Book book);
	    
	    // 验证事物的传播行为Propagation.Mandatory
	    public void addBookPropagationMandatory(Book book);
	    
	    
	    // 验证事物的传播行为Propagation.Required
	    public void addBookPropagationRequired(Book book);
	    
}
