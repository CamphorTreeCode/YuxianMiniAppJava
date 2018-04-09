package com.woman.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woman.pojo.BusinessCompany;

//买卖公司的
public interface BusinessCompanyMapper {

//计数
 int selectCount ();
// 查询页面的数据集合
 
 List<BusinessCompany> findByPage(HashMap<String,Object> map);
// 增加浏览量
  int updateViews(@Param("businessCompanyBrowse")int businessCompanyBrowse,@Param("businessCompanyId")int businessCompanyId);
//  查询单个买卖公司的id
BusinessCompany  selectBusinessCompanys(int businessCompanyId);
}
