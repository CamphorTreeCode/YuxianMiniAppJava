package com.woman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.companyMapper;
import com.woman.dao.shareholderMapper;
import com.woman.pojo.company;
import com.woman.pojo.shareholder;
import com.women.service.CompanyService;

@Service("CompanyServer")
public class CompanyServerImpl implements CompanyService {
	@Autowired
    private	shareholderMapper  shar;
	@Autowired
	private companyMapper companyMapper;
	
	@Override
	public int insertCompany(company s) {
		// TODO 自动生成的方法存根
        //	先增加一个公司 返回一个id
	int companyId	= companyMapper.insert(s);
        //	批量增加股东
		List<shareholder>  sharList = s.getShareholder();
		shar.insertMore(sharList);
		
		return 0;
	}

}
