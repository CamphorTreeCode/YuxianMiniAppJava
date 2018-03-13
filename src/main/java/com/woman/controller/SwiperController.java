package com.woman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.woman.pojo.swiper;
import com.woman.tool.DateTime;
import com.woman.tool.UploadHelper;
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
	@RequestMapping("swiper")
	public String swiperIndex(HttpServletRequest request){
		List<swiper> swiList =swiperService.orderById();
		for (int i = 0; i < swiList.size(); i++) {
			request.setAttribute("s"+i, swiList.get(i));
		}
		
		return "swiper/swiper"; 
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public void update(swiper s) throws Exception{
		System.out.println("**-*-*-*-*-*-***-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		new DateTime();
		System.out.println(s.getCreatetime());
		s.setCreatetime(DateTime.getDate());
		swiperService.update(s);
		int id=s.getSwiperid();
	    
		
	}
	@RequestMapping(value="update1",method=RequestMethod.POST)
	public void update1(swiper s,MultipartFile file,HttpServletRequest request,String img1,HttpServletResponse response) throws IOException{
		System.out.println("**-*-*-*-*-*-***-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		int id=s.getSwiperid();
		String img=UploadHelper.upload(file, request);
		if(img==""){
		    s.setUrl(img1);
		}
		else{
		System.out.println(img);
		s.setUrl(img);
		}
		s.setCreatetime(DateTime.getDate());
		swiperService.update(s);
		swiper swi=swiperService.getById(id);
		JSONArray jsonObject = JSONArray.fromObject(swi);
		PrintWriter pw = response.getWriter();
		pw.print(jsonObject);
	    
		
	}
}
