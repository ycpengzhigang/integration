package com.min.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.min.entity.Book;
import com.min.mapper.BookMapper;
import com.min.service.BookService;
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper,Book> implements BookService {

	/**
	 *  加入事物
	 *  默认的传播级别:REQUIRED
	 *  该事物嵌套在 addUser中的事物中
	 *  此时的情况是该方法会先判断是否是否处于另一个事物中,如果不在则启动本身的事物
	 *  则启动本身的事物
//	 */
//	@Transactional  
//	public void addBook() {
//		// 插入一本书
//		Book book = new Book();
//		book.setId(1);
//		book.setName("duck-j2ee");
//		
//		baseMapper.insert(book);
//		
////		throw new RuntimeException();
//	}

	@Override
	@Transactional
	public void addBook(Book book) {
		baseMapper.insert(book);
//		throw new RuntimeException();
	}

	@Override
	@Transactional(propagation =Propagation.MANDATORY )
	public void addBookPropagationMandatory(Book book) {
		baseMapper.insert(book);
//		throw new RuntimeException();
	}

	@Override
	@Transactional(propagation =Propagation.NESTED,rollbackFor = RuntimeException.class )
	public void addBookPropagationRequired(Book book) {
		baseMapper.insert(book);
		throw new RuntimeException();
	}

}
