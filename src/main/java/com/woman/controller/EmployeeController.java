package com.woman.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woman.pojo.company;

@Controller 
@RequestMapping("/employee")
public class EmployeeController {
	 @RequestMapping(value="/addEmployee",method = RequestMethod.GET)  
	 public String selectColumn() throws IOException{
	 System.out.println("进来");
		 return "employeeManagement/employeeManagement_add";
	 }
}
