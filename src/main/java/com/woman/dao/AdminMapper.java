package com.woman.dao;

import java.util.HashMap;
import java.util.List;

import com.woman.pojo.Admin;

public interface AdminMapper {

	Admin selectAdmin(Admin admin);
  //增加员工的方法
	int insertEmployee(Admin a);
  //修改员工的方法
	int updateEmployee(Admin a);
	//查询单个员工
	Admin selectEmployee(Integer amdinId);
	//分页查询员工
	List<Admin> selectBypage(HashMap<String,Object> map);
	//得到员工总数
	int selectCount();
	//删除一个员工
	int del(int adminid);
	//根据名称获取用户
	String getByAdminname(String Adminname);
}
