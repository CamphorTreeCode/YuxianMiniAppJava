package com.woman.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.woman.pojo.Admin;
import com.woman.pojo.company;
import com.woman.tool.DateTime;
import com.woman.tool.UploadHelper;
import com.women.service.EmployeeService;

@Controller 
@RequestMapping("/employee")
public class EmployeeController {
	 @Autowired
	 private EmployeeService es;
	 
   //	跳转页面
	 @RequestMapping(value="/EmployeePage",method = RequestMethod.GET)  
	 public String EmployeePage() throws IOException{
	 System.out.println("进来");
		 return "employeeManagement/employeeManagement_add";
	 }
	 
  //	 增加员工数据
	 @RequestMapping(value="/addEmployee",method = RequestMethod.POST)  
	 public String addEmployee(Admin adm,MultipartFile file,HttpServletRequest request) throws IOException{
		 adm.setAdminCrateTime(DateTime.getDate());
		 String img=UploadHelper.upload(file, request);
		 System.out.println(img);
		 adm.setAdminImgUrl(img);
	     System.out.println("进来"+adm);
	     adm.setAdminState(1);
	     int num =es.addEmployee(adm);
	     if(num>0){
	    	 System.out.println("增加成功！");
	     }
	 return "employeeManagement/employeeManagement_add";
	 }
	  //	 修改员工数据
		 @RequestMapping(value="/updateEmployee",method = RequestMethod.POST)  
		 public String updateEmployee(Admin adm, MultipartFile file,HttpServletRequest request) throws IOException{
			 adm.setAdminCrateTime(DateTime.getDate());
			 String img=UploadHelper.upload(file, request);
			 System.out.println(img);
			 adm.setAdminImgUrl(img);
		     System.out.println("进来");
		     int num =es.updateEmployee(adm);
		     if(num>0){
		    	 System.out.println("修改成功！");
		     }
	    return "employeeManagement/employeeManagement_add";
		 }
		 //查询单个数据
		 @RequestMapping(value="/selectEmployee",method = RequestMethod.GET)  
		 public String selectEmployee(Integer adminid,Model model) throws IOException{
			 model.addAttribute("admin",es.selectEmployee(adminid));
		    // System.out.println("进来"+es.selectEmployee(adminid));
		
	    return "employeeManagement/employeeManagement_update";
		 }
}
