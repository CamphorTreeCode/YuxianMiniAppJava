package com.woman.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.woman.tool.Page;
import com.woman.dao.noticeMapper;
import com.woman.pojo.notice;
import com.women.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService {
	
    @Autowired
    noticeMapper noticeMapper;
	@Override
	public int add(notice n) {
		// TODO Auto-generated method stub
		return noticeMapper.insert(n);
	}
	@Override
	public Page<notice> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
        Page<notice> pageBean = new Page<notice>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=10;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = noticeMapper.SelectCount(0);
        pageBean.setTotalCount(totalCount);
        System.out.println(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
       
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<notice> lists = noticeMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
	}
	@Override
	public List<notice> findBytime() {
		// TODO Auto-generated method stub
		return noticeMapper.findBytime();
	}
	@Override
	public Page<notice> findByState(int currentPage, int state) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
        Page<notice> pageBean = new Page<notice>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=10;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = noticeMapper.SelectCount(state);
        pageBean.setTotalCount(totalCount);
        System.out.println(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
       
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("state", state);
        //封装每页显示的数据
        List<notice> lists = noticeMapper.findByState(map);
        pageBean.setLists(lists);

        return pageBean;
	}
	
}
