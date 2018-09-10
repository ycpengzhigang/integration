package com.min.facade;

import org.springframework.beans.factory.annotation.Autowired;

import com.min.entity.Book;
import com.min.entity.User;
import com.min.service.BookService;
import com.min.service.UserService;

public class ServiceFacade {
	
	@Autowired
	private BookService bs;  
	
	@Autowired
    private UserService us;  
	
      
    public void addUserBook(Book book, User user)throws Exception{  
        bs.addBook(book);  
        us.addUserPropagationMandatory(book,user);  
    }  
}
