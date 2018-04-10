package com.woman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.AdminMapper;
import com.woman.pojo.Admin;
import com.women.service.EmployeeService;
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	AdminMapper adm;
	//增加员工的方法
	@Override
	public int addEmployee(Admin a) {
		// TODO 自动生成的方法存根
		return adm.insertEmployee(a);
	}
   //修改员工的方法
	@Override
	public int updateEmployee(Admin a) {
		// TODO 自动生成的方法存根
		return  adm.updateEmployee(a);
	}
	//根据id查询单个员工方法
	@Override
	public Admin selectEmployee(Integer amdinId) {
		// TODO 自动生成的方法存根
		return adm.selectEmployee(amdinId);
	}

}
