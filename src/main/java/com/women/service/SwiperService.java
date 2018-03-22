package com.women.service;

import java.util.List;

import com.woman.pojo.swiper;

public interface SwiperService {

	
    //	查询全部的轮播图前三张
	List<swiper> selectSwiperAll();
}
