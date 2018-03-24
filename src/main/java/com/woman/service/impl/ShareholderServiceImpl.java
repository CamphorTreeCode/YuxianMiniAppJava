package com.woman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.pojo.shareholder;
import com.women.service.ShareholderService;
@Service
public class ShareholderServiceImpl implements ShareholderService {
     //查询单个公司id的所有股东
    @Autowired
	com.woman.dao.shareholderMapper shareholderMapper;
	@Override
	public List<shareholder> selectCompanyId(int companyid) {
		// TODO 自动生成的方法存根
		
		return shareholderMapper.selectCompanyId(companyid);
	}

}
