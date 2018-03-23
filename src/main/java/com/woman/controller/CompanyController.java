package com.woman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woman.pojo.company;
import com.woman.tool.GetOpenId;
import com.women.service.CompanyService;

//http://shensu.free.ngrok.cc/Maven_Project/tool/addImg

@Controller 
@RequestMapping("/company")
public class CompanyController {
 @Autowired
private CompanyService companyService;
  
	 //查询栏目列
	 @RequestMapping(value="/addCompany",method = RequestMethod.POST)  
	 @ResponseBody
	 public void selectColumn(@RequestBody  company company,HttpServletResponse response) throws IOException{
		
           if(company.getCompanyname()==null){
        	   return;
           }
     //1.	拿到数据 打印	
	    System.out.println(company.toString());	
	    response.setContentType("text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");

	 //	 System.out.println(company[0].getShareholder()[0].toString());
     //2.	 改变对象数据
	    String jscode = company.getJscode();
		company.setOpenid(GetOpenId.getOpenid(jscode)); 
     //3.  查询数据
		   long starTime = System.currentTimeMillis();
		int num = companyService.selectCompanyName(company.getCompanyname());
		if(num>0){
			System.out.println("数据库已经存在了");
			  long  endTime=System.currentTimeMillis();
	    	  long   Time=endTime-starTime;
	    	System.out.println("花费的时间："+Time);
	    	PrintWriter pw = response.getWriter();
	      pw.print("公司名已经存在");
	    			
			return;
		}
		//4.存入数据库		 
	    companyService.insertCompany(company);
	 }
    //查询公司页面
		@RequestMapping(value="/companyPage",method=RequestMethod.GET)
		public String companyPage(Model model){
			
//			model.addAttribute("companyPage",companyService.findByPage(currentPage));
			return "company/company";
		}
//     //	查询公司全部的
//		@RequestMapping(value="/companyAll",method=RequestMethod.GET)
//		public String companyAll(){			
//			model.addAttribute("noticePage",noticeService.findByPage(currentPage));
//			return "company/company";
//		}
	 }
