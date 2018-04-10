package com.women.service;

import com.woman.pojo.Admin;

public interface EmployeeService {

	
	//增加员工的方法
    int	addEmployee(Admin a);
    //修改员工的方法
    int updateEmployee(Admin a);
    //查询单个员工
    Admin selectEmployee(Integer amdinId);
	
}
