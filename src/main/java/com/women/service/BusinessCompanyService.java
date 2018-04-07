package com.women.service;

import com.woman.pojo.BusinessCompany;

import com.woman.tool.Page;

public interface BusinessCompanyService {
	
	Page<BusinessCompany> getByBusinessCompany(int currentPage,int businessCompany);

}
