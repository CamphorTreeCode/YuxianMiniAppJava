package com.woman.dao;

import java.util.List;

import com.woman.pojo.CompanyImg;

//公司上传图片接口
public interface CompanyImgMapper {
	//出入一条记录
	int insertCompanyImgMapper(CompanyImg c);
    
	//根据businessCompanyId查询一个图片集合
	
	List<CompanyImg> getByBid(int businessCompanyId);
	
	//根据businessCompanyId删除图片关联
	int deleteByBid(int businessCompanyId);
}
