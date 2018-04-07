/**
 * 
 */
package com.woman.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.woman.pojo.notice;
import com.women.service.WXBusinessCompanyService;

import net.sf.json.JSONArray;

/**
 * @author YUKI
 *微信小程序的查询买卖公司
 */
@Controller 
@RequestMapping("/wbcc")
public class WXBusinessCompanyController {
	 @Autowired
	 WXBusinessCompanyService wxbcs;
      //	 查询买卖公司信息
		@RequestMapping("/selectCompany")
		public void  addViewCount(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,HttpServletResponse response)throws IOException{
			
	  
	        
			System.out.println("浏览量为"+currentPage);
			response.setCharacterEncoding("utf-8");
			JSONArray jsonArray = JSONArray.fromObject(wxbcs.selectBusinessCompany(currentPage));
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray);

			
		}
	 
}
