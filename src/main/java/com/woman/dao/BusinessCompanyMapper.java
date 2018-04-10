package com.woman.dao;

import java.util.HashMap;
import java.util.List;


import com.woman.pojo.BusinessCompany;

//买卖公司的
public interface BusinessCompanyMapper {
    //根据买或卖分页
	List<BusinessCompany> getByBusinessCompany(HashMap<String,Object> map);
    //查询买或卖的总数
	Integer SelectCount(HashMap<String,Object> map);

//计数
 int selectCount ();
// 查询页面的数据集合
 
 List<BusinessCompany> findByPage(HashMap<String,Object> map);
 //插入一条记录
 int insertbusinessCompany(BusinessCompany b);
 //修改一条记录
 int updatebusinessCompany(BusinessCompany b);
 //根据id获取一条记录
 BusinessCompany findById(int id);
 //删除一条记录
 int deletebusinessCompany(int id);
 
}
