package com.woman.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woman.pojo.Admin;
import com.women.service.LoginService;

@Controller 
@RequestMapping("/login/")
public class LoginController {
	@Autowired
	private LoginService LoginService;
	 	
	//注销登录跳转
	 @RequestMapping(value="tologin",method = RequestMethod.GET)  
	 public String login() throws IOException{
		 System.out.println("tologin");
      return "redirect:/index.jsp";
	 }
    //登录
		@RequestMapping("login")
		public String userLogin(String user_name,String user_password,String check,
				HttpServletRequest request,HttpServletResponse response){
			
			 request.getSession().removeAttribute("error");
			 Admin adm = new Admin(user_name,user_password);
			 Admin user=LoginService.Login(adm);
			 System.out.println(user.getAdminState()+"lllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
			 if(user==null){
				 request.getSession().setAttribute("error", "用户名或密码错误");
				 return "redirect:/index.jsp";
			 }else{
//				 if("Y".equals(check)){
//						Cookie unCookie=new Cookie("user_name",user_name);
//						unCookie.setPath("/");
//						unCookie.setMaxAge(365*24*60*60);
//						Cookie pwCookie=new Cookie("user_password",user_password);
//						pwCookie.setPath("/");
//						pwCookie.setMaxAge(365*24*60*60);
//						response.addCookie(unCookie);
//						response.addCookie(pwCookie);
//						request.getSession().setAttribute("user_name", user.getAdminName());
//						return "redirect:/blogsController/manageBlogs.htmls";
//					}
//					else{
						Cookie unCookie=new Cookie("user_name",user_name);
						unCookie.setPath("/");
						unCookie.setMaxAge(0);
						Cookie pwCookie=new Cookie("user_password",user_password);
						pwCookie.setPath("/");
						pwCookie.setMaxAge(0);
						response.addCookie(unCookie);
						response.addCookie(pwCookie);
						request.getSession().setAttribute("user", user);
						request.getSession().setAttribute("user_name", user.getAdminName());
						 return "redirect:/notice/index";
					//}

			 }
		}  
}
