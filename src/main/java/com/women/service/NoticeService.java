package com.women.service;

import java.util.List;


import com.woman.pojo.notice;
import com.woman.tool.Page;


public interface NoticeService {
	
	public int add(notice n);
	
	
    /*分页查询*/
    Page<notice> findByPage(int currentPage);
    
    
    /*查询最新公告*/
    
    List<notice> findBytime();
    
    /*按状态查询  （草稿箱  待发布   已发布）*/
    Page<notice> findByState(int currentPage,int state);
    
}
