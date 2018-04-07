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
	public Page<BusinessCompany> selectBusinessCompany(int currentPage) {
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
       
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<BusinessCompany> lists = bcm.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
	}

}
