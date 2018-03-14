package com.woman.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woman.pojo.user;
import com.woman.tool.DateTime;
import com.woman.tool.GetOpenId;
import com.women.service.UserService;

@Controller 
@RequestMapping("/user/")
public class UserController {
 @Autowired
private UserService userService;
  
	 //增加用户
	 @RequestMapping(value="addUser",method = RequestMethod.POST) 
	 @ResponseBody
	 public void selectColumn(@RequestBody user user) throws IOException{
		 
        //1.接收数据 打印处理	    
		 System.out.println(user);
        //2.取出数据 添加数据
		  user.setOpenid(GetOpenId.getOpenid(user.getJscode())); 
		  user.setRegisterdate(DateTime.getDate());
        //3.	查询数据库有不需要添加	
		   long starTime = System.currentTimeMillis();
		int num =  userService.selectUser(user.getOpenid());
       if(num>0){
    	  System.out.println("已经存在！不添加");
    	  long  endTime=System.currentTimeMillis();
    	    long   Time=endTime-starTime;
    		  System.out.println("花费的时间："+Time);
    	   return;
       }
   
		//4.存入数据库		   
		  userService.insetUser(user);
		 
       }
	 }
