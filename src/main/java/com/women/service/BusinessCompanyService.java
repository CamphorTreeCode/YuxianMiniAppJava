package com.women.service;

import com.woman.pojo.BusinessCompany;

import com.woman.tool.Page;

public interface BusinessCompanyService {
	
	Page<BusinessCompany> getByBusinessCompany(int currentPage,int businessCompany,int adminState,int adminId);

	int insertbusinessCompany(BusinessCompany b);
	
	int updateBusinessCompany(BusinessCompany b);
	
	BusinessCompany findById(int id);
	
	//删除一条记录
	 int deletebusinessCompany(int id);
}
