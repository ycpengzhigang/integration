package com.min.service;

import com.baomidou.mybatisplus.service.IService;
import com.min.entity.User;

public interface UserService extends IService<User>{
//	  public static final String ADD_USER="insert into t_user(id,name) values(1,'duck')";  
	 
	  void addUser();
}
