package com.min.service;

import com.baomidou.mybatisplus.service.IService;
import com.min.entity.Book;

public interface BookService extends IService<Book>{
//	   public static final String ADD_BOOK="insert into t_book(id,name) values(1,'duck-j2ee')";  
	      
	    public void addBook();
}
