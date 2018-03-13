package com.woman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.swiperMapper;
import com.woman.pojo.swiper;
import com.women.service.SwiperService;
@Service
public class SwiperServiceImpl implements SwiperService {
     //查询轮播图全部
	   @Autowired
	   swiperMapper swiperMapper;
	   
	@Override
	public List<swiper> selectSwiperAll() {
		// TODO 自动生成的方法存根
		
		return swiperMapper.selectSwiper();
	}

	@Override
	public int update(swiper s) {
		// TODO Auto-generated method stub
		
		return swiperMapper.updateByPrimaryKey(s);
	}

	@Override
	public swiper getById(int id) {
		// TODO Auto-generated method stub
		return swiperMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<swiper> orderById() {
		// TODO Auto-generated method stub
		return swiperMapper.orderById();
	}

}
