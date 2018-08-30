package com.min.service;

import com.baomidou.mybatisplus.service.IService;
import com.min.entity.Book;

public interface BookService extends IService<Book>{
	      
	    public void addBook(Book book);
	    
}
