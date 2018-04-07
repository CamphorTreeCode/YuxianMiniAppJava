package com.women.service;

import com.woman.pojo.BusinessCompany;
import com.woman.tool.Page;

public interface WXBusinessCompanyService {
//  根据最新时间分页查询买卖公司
  Page<BusinessCompany> selectBusinessCompany(int currentPage);
}
