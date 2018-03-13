package com.woman.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

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
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		System.out.println("*************************************");
		
		return "notice/index";
	}
	@RequestMapping(value="/wxIndex",method=RequestMethod.GET)
	public String wxIndex(){
		System.out.println("*************************************");
		
		return "notice/wxIndex";
	}
	/*跳转公告添加页面*/
	@RequestMapping(value="/addnotice",method=RequestMethod.GET)
	public String add(){
		
		
		return "notice/issueNotice";
	}
	/*添加公告*/
	@RequestMapping(value="/addnotice",method=RequestMethod.POST)
	public String addsave(notice n,MultipartFile file,HttpServletRequest request) throws IOException{
		String img=UploadHelper.upload(file, request);
		System.out.println(img);
		n.setImg(img);
		n.setCreatetime(new DateTime().getDate());
		noticeService.add(n);
		return "redirect:getbystate";
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
			Model model,@RequestParam(value="state",defaultValue="1",required=false)int state){
		System.out.println("进入分类分页");
		
		model.addAttribute("noticePage",noticeService.findByState(currentPage,state));
		model.addAttribute("state",state);
		return "notice/drafts";
		
	}
	@RequestMapping("/look")
	public String look(int id,Model model){
		notice n=noticeService.selectByPrimaryKey(id);
		int state=n.getState();
		model.addAttribute("notice",n);
		model.addAttribute("state",state);
		 return "notice/look";
	}
	@RequestMapping("/submit")
	public String submit(notice n,MultipartFile file,HttpServletRequest request)throws IOException{
		System.out.println("***********************************");
		System.out.println(n.getNoticeid());
		n.setCreatetime(new DateTime().getDate());
		n.setState(2);
		String img=UploadHelper.upload(file, request);
		System.out.println(img);
		n.setImg(img);
		if(n.getNoticeid()==null){
			
			noticeService.add(n);
		}else{
		  noticeService.updateByPrimaryKeySelective(n);
		}
		return "redirect:getbystate";
	}
	@RequestMapping("/wait")
	public String wait(notice n,MultipartFile file,HttpServletRequest request) throws IOException{
		System.out.println("***********************************");
		n.setState(1);
		String img=UploadHelper.upload(file, request);
		System.out.println(img);
		n.setImg(img);
		noticeService.updateByPrimaryKeySelective(n);
		return "redirect:getbystate";
	}
}
