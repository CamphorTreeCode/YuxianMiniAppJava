package com.woman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.AdminMapper;
import com.woman.dao.userMapper;
import com.woman.pojo.Admin;
import com.women.service.LoginService;
@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private AdminMapper admin;
	@Override
	public Admin Login(Admin adm) {
		// TODO 自动生成的方法存根
		return admin.selectAdmin(adm);
	}


}
