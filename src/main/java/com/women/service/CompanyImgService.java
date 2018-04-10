package com.women.service;

import java.util.List;

import com.woman.pojo.CompanyImg;

public interface CompanyImgService {
    //插入一条 记录
	int insertCompanyImgMapper(CompanyImg c);
	
	//根据businessCompanyId查询关联图片集合
	
	List<CompanyImg> getByBid(int businessCompanyId);
	
	//根据businessCompanyId删除关联图片
	
	int deleteByBid(int businessCompanyId);
}
