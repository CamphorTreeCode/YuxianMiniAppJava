package com.women.service;

import java.util.List;

import com.woman.pojo.company;
import com.woman.pojo.shareholder;

public interface CompanyService {
// 增加公司和股东的方法
  int insertCompany (company company);
//  查询数公司名称
  int selectCompanyName(String name);
}
