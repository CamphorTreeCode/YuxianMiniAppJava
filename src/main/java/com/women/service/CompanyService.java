package com.women.service;

import java.util.List;

import com.woman.pojo.company;
import com.woman.pojo.shareholder;
import com.woman.tool.Page;

public interface CompanyService {
// 增加公司和股东的方法
  int insertCompany (company company);
//  查询数公司名称
  int selectCompanyName(String name);
//  分页查询公司
  Page<company> selectCompanyAll(int currentPage);
  
//  公司查询公司股东
  company comList(int companyId);
}
