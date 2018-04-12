package com.woman.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.AdminMapper;
import com.woman.dao.BusinessCompanyMapper;
import com.woman.pojo.Admin;
import com.woman.pojo.notice;
import com.woman.tool.Page;
import com.women.service.EmployeeService;
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	AdminMapper adm;
	@Autowired
	BusinessCompanyMapper bcm;
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
	@Override
	public Page<Admin> getByPage(int currentPage) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				HashMap<String,Object> map = new HashMap<String,Object>();
		        Page<Admin> pageBean = new Page<Admin>();

		        //封装当前页数
		        pageBean.setCurrPage(currentPage);

		        //每页显示的数据
		        int pageSize=5;
		        pageBean.setPageSize(pageSize);

		        //封装总记录数
		        int totalCount = adm.selectCount();
		        //封装总页数
		        double tc = totalCount;
		        Double num =Math.ceil(tc/pageSize);//向上取整
		        pageBean.setTotalPage(num.intValue());
		       
		        map.put("start",(currentPage-1)*pageSize);
		        map.put("size", pageBean.getPageSize());
		        //封装每页显示的数据
		        List<Admin> lists = adm.selectBypage(map);
		        pageBean.setLists(lists);
		        return pageBean;
	}
	@Override
	public int del(int adminid) {
		// TODO Auto-generated method stub
		
		return adm.del(adminid);
	}

}
