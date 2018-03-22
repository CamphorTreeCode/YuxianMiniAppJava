package com.woman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woman.pojo.swiper;
import com.women.service.SwiperService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/swiper/")
public class SwiperController {
	@Autowired
	SwiperService swiperService;
	@RequestMapping("selectAll")
	public void index(HttpServletResponse response) throws IOException{
		System.out.println("*************************************");
		response.setCharacterEncoding("utf-8");
		System.out.println("进来了");
		List<swiper> swiList =swiperService.selectSwiperAll();
		JSONArray jsonArray = JSONArray.fromObject(swiList);
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
}
