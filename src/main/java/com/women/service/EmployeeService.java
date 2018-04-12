package com.women.service;

import com.woman.pojo.Admin;
import com.woman.tool.Page;

public interface EmployeeService {

	
	//增加员工的方法
    int	addEmployee(Admin a);
    //修改员工的方法
    int updateEmployee(Admin a);
    //查询单个员工
    Admin selectEmployee(Integer amdinId);
	//分页查询
    Page<Admin> getByPage(int currentPage);
    
  //删除一个员工
  	int del(int adminid);
    //根据名字查询员工
  	String getByAdminname(String Adminname);
}
