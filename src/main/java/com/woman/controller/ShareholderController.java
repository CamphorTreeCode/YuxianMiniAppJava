package com.woman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woman.pojo.shareholder;
import com.women.service.CompanyService;
import com.women.service.ShareholderService;

import net.sf.json.JSONArray;
@Controller
@RequestMapping("/shareholder")
public class ShareholderController {
	@Autowired
	ShareholderService shareholderService;
	 @Autowired
	 private CompanyService companyService;
//	查询单公司个股东 修改查看状态
	@RequestMapping(value="/selectShareholder",method=RequestMethod.GET)
	public void companyPage(int companyid,int showState,HttpServletResponse response) throws IOException{
		List<shareholder> sharList = shareholderService.selectCompanyId(companyid);
	 if(showState==1){
		 System.out.println("不需要修改！");
	 }else{
			int num =	companyService.updataState(companyid);
			 if(num>0){
				 System.out.println("修改成功！");
			 }
				 
	 }
	
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(sharList);
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
		System.out.println(companyid);
	 
	}
}
