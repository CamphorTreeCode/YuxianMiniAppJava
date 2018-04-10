package com.woman.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.BusinessCompanyMapper;
import com.woman.pojo.BusinessCompany;
import com.woman.tool.Page;
import com.women.service.BusinessCompanyService;
@Service
public class BusinessCompanyServiceImpl implements BusinessCompanyService {
    
	@Autowired
	BusinessCompanyMapper businessCompanyMapper;
    
	/*根据买 或 卖状态实现相应分页*/
	@Override
	public Page<BusinessCompany> getByBusinessCompany(int currentPage, int businessCompany,int adminState,int adminId) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		HashMap<String,Object> map1 = new HashMap<String,Object>();
		map1.put("businessCompany", businessCompany);
		map1.put("adminState", adminState);
		map1.put("adminId", adminId);
		Page<BusinessCompany> pageBean = new Page<BusinessCompany>();

		//封装当前页数
		pageBean.setCurrPage(currentPage);

		//每页显示的数据
		int pageSize=5;
		pageBean.setPageSize(pageSize);

		//封装总记录数
		int totalCount = businessCompanyMapper.SelectCount(map1);
		pageBean.setTotalCount(totalCount);
		System.out.println(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("businessCompany", businessCompany);
		map.put("adminState", adminState);
		map.put("adminId", adminId);
		//封装每页显示的数据
		List<BusinessCompany> lists = businessCompanyMapper.getByBusinessCompany(map);
		pageBean.setLists(lists);

		return pageBean;
	}
	//插入一条记录
	@Override
	public int insertbusinessCompany(BusinessCompany b) {
		// TODO Auto-generated method stub
		return businessCompanyMapper.insertbusinessCompany(b);
	}
	//修改一条记录
	@Override
	public int updateBusinessCompany(BusinessCompany b) {
		// TODO Auto-generated method stub
		return businessCompanyMapper.updatebusinessCompany(b);
	}
	//根据id得到一条记录
	@Override
	public BusinessCompany findById(int id) {
		// TODO Auto-generated method stub
		return businessCompanyMapper.findById(id);
	}
	@Override
	public int deletebusinessCompany(int id) {
		// TODO Auto-generated method stub
		return businessCompanyMapper.deletebusinessCompany(id);
	}




}
