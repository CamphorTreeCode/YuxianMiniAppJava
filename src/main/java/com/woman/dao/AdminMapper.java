package com.woman.dao;

import com.woman.pojo.Admin;

public interface AdminMapper {

	Admin selectAdmin(Admin admin);
  //增加员工的方法
	int insertEmployee(Admin a);
  //修改员工的方法
	int updateEmployee(Admin a);
	//查询单个员工
	Admin selectEmployee(Integer amdinId);
}
