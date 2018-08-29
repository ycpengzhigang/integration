package com.min.facade;

import com.min.service.BookService;
import com.min.service.UserService;

public class ServiceFacade {
	private BookService bs;  
    private UserService us;  
    public BookService getBs() {  
        return bs;  
    }  
    public void setBs(BookService bs) {  
        this.bs = bs;  
    }  
    public UserService getUs() {  
        return us;  
    }  
    public void setUs(UserService us) {  
        this.us = us;  
    }  
      
    public void addUserBook()throws Exception{  
        bs.addBook();  
        us.addUser();  
    }  
}
