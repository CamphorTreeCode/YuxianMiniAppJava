package com.woman.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.woman.pojo.Admin;
import com.woman.tool.DateTime;
import com.woman.tool.Token;
import com.woman.tool.UploadHelper;
import com.women.service.EmployeeService;

@Controller 
@RequestMapping("/employee")
public class EmployeeController {
	 @Autowired
	 private EmployeeService es;
	 
   //	跳转页面  
	 @Token(save=true)
	 @RequestMapping(value="/EmployeePage",method = RequestMethod.GET)  
	 public String EmployeePage() throws IOException{
	 System.out.println("进来");
		 return "employeeManagement/employeeManagement_add";
	 }
	 
  //	 增加员工数据
	 @Token(remove=true)
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
	 return "redirect:list";
	 }
	  //	 修改员工数据
	     @Token(remove=true)
		 @RequestMapping(value="/updateEmployee",method = RequestMethod.POST)  
		 public String updateEmployee(Admin adm, MultipartFile file,HttpServletRequest request,String file1) throws IOException{
			 adm.setAdminCrateTime(DateTime.getDate());
			 String img=UploadHelper.upload(file, request);
			 if(img==""){
				 adm.setAdminImgUrl(file1);
			 }
			 else{
			 adm.setAdminImgUrl(img);
			 }
		     System.out.println("进来");
		     int num =es.updateEmployee(adm);
		     if(num>0){
		    	 System.out.println("修改成功！");
		     }
	    return "redirect:list";
		 }
		 //查询单个数据
		 @Token(save=true)
		 @RequestMapping(value="/selectEmployee",method = RequestMethod.GET)  
		 public String selectEmployee(Integer adminid,Model model) throws IOException{
			 model.addAttribute("admin",es.selectEmployee(adminid));
		    // System.out.println("进来"+es.selectEmployee(adminid));
		
	        return "employeeManagement/employeeManagement_update";
		 }
		 //查找员工列表分页
		 @RequestMapping("list")
		 public String list(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model){
			 System.out.println(es.getByPage(currentPage).getTotalCount()+"ttttttttttttttttttttttttttttttttttttttttt");
			 model.addAttribute("employeePage",es.getByPage(currentPage));
			 return "employeeManagement/employeeManagement_list";
		 }
		 @RequestMapping("del")
		 public String del(int adminid){
			 es.del(adminid);
			 return "redirect:list";
		 }
}
