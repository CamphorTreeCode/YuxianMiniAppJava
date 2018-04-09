package com.woman.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.BusinessCompanyMapper;
import com.woman.pojo.BusinessCompany;
import com.woman.pojo.company;
import com.woman.tool.Page;
import com.women.service.WXBusinessCompanyService;

/**
 * @author YUKI
 *
 */
@Service("WXBusinessCompanyService")
public class WXBusinessCompanyServiceImpl implements WXBusinessCompanyService {
   //按时间查询分页的买卖公司    
	@Autowired
	BusinessCompanyMapper bcm;
	@Override
	public Page<BusinessCompany> selectBusinessCompany(int currentPage,BusinessCompany bcy) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        Page<BusinessCompany> pageBean = new Page<BusinessCompany>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=3;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = bcm.selectCount();
        pageBean.setTotalCount(totalCount);
        System.out.println(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        System.out.println(bcy);
        System.out.println(bcy.getBusinessCompany());
     System.out.println(bcy.getBusinessCompanyRegion()!=null);
     System.out.println(bcy.getBusinessCompany()!=null);
     System.out.println(bcy.getBusinessCompanyAccount()!=null);
       map.put("businessCompanyRegion",bcy.getBusinessCompanyRegion());
       map.put("businessCompany",bcy.getBusinessCompany());
       map.put("businessCompanyPayTaxes",bcy.getBusinessCompanyPayTaxes());
       map.put("businessCompanyAccount",bcy.getBusinessCompanyAccount());
        map.put("businessCompanyIndustry",bcy.getBusinessCompanyIndustry());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<BusinessCompany> lists = bcm.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
	}
	//查询单个信息 增加浏览量
	@Override
	public BusinessCompany selectOneBusinessCompany(int businessCompanyOId) {
		BusinessCompany bc  =	bcm.selectBusinessCompanys(businessCompanyOId);
		if(bc != null){
			System.out.println(bc.getBusinessCompanyBrowse()+1);
			bc.setBusinessCompanyBrowse(bc.getBusinessCompanyBrowse()+1);
			int num =bcm.updateViews(bc.getBusinessCompanyBrowse(), businessCompanyOId);
			if(num>0){
				System.out.println("增加浏览量成功");
			}
		}
		return bc;
	}

}
