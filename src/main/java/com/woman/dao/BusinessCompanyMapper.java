package com.woman.dao;

import java.util.HashMap;
import java.util.List;

import com.woman.pojo.BusinessCompany;

//买卖公司的
public interface BusinessCompanyMapper {

	
	List<BusinessCompany> getByBusinessCompany(HashMap<String,Object> map);
    
	Integer SelectCount(int businessCompany);
}
