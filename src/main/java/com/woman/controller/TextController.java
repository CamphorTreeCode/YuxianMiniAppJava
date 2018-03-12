package com.woman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.woman.pojo.text;
import com.woman.tool.DateTime;
import com.woman.tool.UploadHelper;
import com.women.service.TextService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/text")
public class TextController {
	@Autowired
	TextService textService;
	@RequestMapping("/getByType")
	public void getByType(int type,HttpServletResponse response)throws IOException{
	   text t=textService.getByType(type);
	   System.out.println(t.getContext());
	   System.out.println("**************************");
	   response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(t);
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	@RequestMapping("/update")
	public String update(text t,MultipartFile file,HttpServletRequest request) throws IOException{
		System.out.println("进入text--------------------------------");
		String img=UploadHelper.upload(file, request);
		System.out.println(img);
		t.setImg(img);
		textService.updateText(t);
		return "redirect:getByType";
	}
	@RequestMapping("/textindex")
	public String textIndex(){
		return "text/text";
	}
	
   //查询全部
	@RequestMapping("/selectAll")
	public void selectAll(HttpServletResponse response) throws IOException{
	     	System.out.println("查询全部");
	    	List<text> t = textService.selectAll();
		   response.setCharacterEncoding("utf-8");
			JSONArray jsonArray = JSONArray.fromObject(t);
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray);
		
	}
	
	

}
