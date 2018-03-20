package com.women.service;

import com.woman.pojo.user;

public interface UserService {

//	增加用户的方法
	int insetUser(user u);
//	根据id查询方法
	int selectUser(String openid);
}
