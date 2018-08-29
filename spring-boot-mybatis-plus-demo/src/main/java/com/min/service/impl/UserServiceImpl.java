package com.min.service.impl;
/*
 * https://www.cnblogs.com/icenter/p/5279728.html 地址
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.min.entity.User;
import com.min.mapper.UserMapper;
import com.min.service.BookService;
import com.min.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
	
	@Autowired
    private BookService bs;  
	
	
	public void addUser() {
		bs.addBook();
	}

	

}
