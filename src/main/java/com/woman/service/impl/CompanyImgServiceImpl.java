package com.woman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.CompanyImgMapper;
import com.woman.pojo.CompanyImg;
import com.women.service.CompanyImgService;
@Service
public class CompanyImgServiceImpl implements CompanyImgService{
    
	@Autowired
	CompanyImgMapper companyImgMapper;
	//插入一条记录
	@Override
	public int insertCompanyImgMapper(CompanyImg c) {
		// TODO Auto-generated method stub
		return companyImgMapper.insertCompanyImgMapper(c);
	}
    //根据businessCompanyId得到与之关联的图片集合
	@Override
	public List<CompanyImg> getByBid(int businessCompanyId) {
		// TODO Auto-generated method stub
		return companyImgMapper.getByBid(businessCompanyId);
	}
	@Override
	public int deleteByBid(int businessCompanyId) {
		
		return companyImgMapper.deleteByBid(businessCompanyId);
	}
}
