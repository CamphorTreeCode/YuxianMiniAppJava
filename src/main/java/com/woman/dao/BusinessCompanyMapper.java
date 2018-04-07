package com.woman.dao;

import java.util.HashMap;
import java.util.List;

import com.woman.pojo.BusinessCompany;

//买卖公司的
public interface BusinessCompanyMapper {

//计数
 int selectCount ();
// 查询页面的数据集合
 
 List<BusinessCompany> findByPage(HashMap<String,Object> map);
}
