package com.woman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.woman.pojo.notice;
import com.woman.tool.DateTime;
import com.woman.tool.UploadHelper;
import com.women.service.NoticeService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	/*跳转公告添加页面*/
	@RequestMapping(value="/addnotice",method=RequestMethod.GET)
	public String add(){
		
		
		return "add";
	}
	/*添加公告*/
	@RequestMapping(value="/addnotice",method=RequestMethod.POST)
	public String addsave(notice n,MultipartFile file,HttpServletRequest request) throws IOException{
		String img=UploadHelper.upload(file, request);
		System.out.println(img);
		n.setImg(img);
		n.setCreatetime(new DateTime().getDate());
		noticeService.add(n);
		return "redirect:list";
	}
	/*公告分页展示*/
	@RequestMapping("/manageNotice")
	public String Test(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,
			Model model){
		System.out.println(noticeService.findByPage(currentPage).getLists().size());
		model.addAttribute("noticePage",noticeService.findByPage(currentPage));
		 
		return "../index";
	}
	/*获取最新公告4条*/
	@RequestMapping("/getnewnotice")
	public void getNewNotice(HttpServletResponse response) throws IOException{
		List<notice> n=noticeService.findBytime();
		for (notice n1 : n) {
			System.out.println(n1.getContext());
		}
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(n);
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
		
	}
	/*根据状态获取公告分页*/
	@RequestMapping("/getbystate")
	public String getBystate(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,
			Model model,int state){
		System.out.println("进入分类分页");
		
		model.addAttribute("noticePage",noticeService.findByState(currentPage,state));
		
		return "../index";
		
	}
}
