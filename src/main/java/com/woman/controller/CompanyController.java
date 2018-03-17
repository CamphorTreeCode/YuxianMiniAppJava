package com.woman.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woman.pojo.company;
import com.women.service.CompanyService;

//http://shensu.free.ngrok.cc/Maven_Project/tool/addImg

@Controller 
@RequestMapping("/company")
public class CompanyController {
 @Autowired
private CompanyService companyService;
	 //查询栏目列
	 @RequestMapping(value="/addCompany",method = RequestMethod.PUT)  
	 @ResponseBody
	 public void selectColumn(@RequestBody  List<company> company) throws IOException{
     //1.	拿到数据
		 for (company company2 : company) {
			 System.out.println(company2.toString());
		}
		  

//	 System.out.println(company[0].getShareholder()[0].toString());
     //2.	 打印
	 	
     //3.   取数据
		
     //4.   存对应的数据
		
     //5。         完成返回给前端的数据    		 
	   
	 }
	 }
