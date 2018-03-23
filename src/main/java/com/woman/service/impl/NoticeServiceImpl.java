package com.woman.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.noticeMapper;
import com.woman.pojo.notice;
import com.woman.tool.Page;
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
        int pageSize=5;
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
        int pageSize=5;
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
	@Override
	public notice selectByPrimaryKey(Integer noticeid) {
		// TODO Auto-generated method stub
		return noticeMapper.selectByPrimaryKey(noticeid);
	}
	@Override
	public int updateByPrimaryKeySelective(notice record) {
		// TODO Auto-generated method stub
		return noticeMapper.updateByPrimaryKey(record);
	}
     //	增加阅读量
	@Override
	public notice addViewCount(int id) {
		// TODO 自动生成的方法存根

		notice notice = noticeMapper.selectViewCount(id);
		System.out.println(notice);
		notice.setViewcount(notice.getViewcount()+1);
		int row =	noticeMapper.updateViewCount(notice.getViewcount(),id);
		if(row>0){
			System.out.println("已经增加"+row);
		}
		return notice;
	}
	
}
