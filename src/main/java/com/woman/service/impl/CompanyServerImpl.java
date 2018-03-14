package com.woman.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
import com.woman.dao.companyMapper;
import com.woman.dao.shareholderMapper;
import com.woman.pojo.company;
import com.woman.pojo.shareholder;
import com.woman.tool.DateTime;
import com.women.service.CompanyService;

@Service("CompanyServer")
public class CompanyServerImpl implements CompanyService {
	@Autowired
    private	shareholderMapper  shar;
	@Autowired
	private companyMapper companyMapper;
	
	@Override
	public int insertCompany(List<company> company) {
		// TODO 自动生成的方法存根
        //	先增加一个公司 返回一个id
		company comp =  company.get(0);
		comp.setCreatetime(DateTime.getDate());
	int   resId	= companyMapper.insert(comp);
	if(resId>0){
		System.out.println("增加成功！");
	}	
        //	批量增加股东
	
  int companyId=comp.getCompanyid();

	System.out.println(company.get(0).getCompanyid());
	
		List<shareholder>  sharList = comp.getShareholder();
		System.out.println(sharList);
		List<shareholder> sharLists = new ArrayList<shareholder>();
	   for (shareholder shareholder : sharList) {
		   shareholder.setCompanyid(companyId);
		   shareholder.setCreatetime(DateTime.getDate());
		   sharLists.add(shareholder);
		   System.out.println(sharLists);
	}
	   for (shareholder shareholder : sharLists) {
		System.out.println(shareholder.toString());
	} 
		System.out.println(sharLists);
		int rid  = shar.insertMore(sharLists);
		if(rid>0){
			System.out.println("批量增加成功！");
		}
		
		return 0;
	}



}
