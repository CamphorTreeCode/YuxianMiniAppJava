package com.woman.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woman.pojo.company;
import com.women.service.CompanyService;



@Controller 
@RequestMapping("/company")
public class CompanyController {
 @Autowired
private CompanyService companyService;
	//查询栏目列
	 @RequestMapping("/addCompany")  
	public void selectColumn(company com) throws IOException{
     //1.	拿到数据
		System.out.println(com);
     //2.	 打印
     //3.   取数据 
     //4.   存对应的数据
     //5。         完成返回给前端的数据    		 
	   
	 }
	 }
