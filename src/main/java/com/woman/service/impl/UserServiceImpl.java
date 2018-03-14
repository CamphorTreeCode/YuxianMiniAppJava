package com.woman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.userMapper;
import com.woman.pojo.user;
import com.women.service.UserService;
@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private userMapper userm;
//	 增加用户
	@Override
	public int insetUser(user u) {
		// TODO 自动生成的方法存根
		int rum = userm.insert(u);
		if(rum>0){
			System.out.println("增加成功！");
		}
		return 0;
	}

	@Override
	public int selectUser(String openid) {
		// TODO 自动生成的方法存根
		int num  =userm.selectUserOpenid(openid);
	
		return num;
	}

}
