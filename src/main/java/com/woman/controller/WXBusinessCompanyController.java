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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woman.pojo.BusinessCompany;
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
		@RequestMapping(value="/selectCompany",method = RequestMethod.GET)
	
		public void  addViewCount(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,String businessCompanyRegion,String  businessCompany,String  businessCompanyPayTaxes,String  businessCompanyAccount,String businessCompanyIndustry,HttpServletResponse response)throws IOException{
			System.out.println("浏览量为"+currentPage+businessCompanyRegion+businessCompany+businessCompanyPayTaxes+businessCompanyAccount+businessCompanyIndustry);
			BusinessCompany bcy = new BusinessCompany();
			bcy.setBusinessCompanyRegion(businessCompanyRegion==null||businessCompanyRegion.equals("null")?null:businessCompanyRegion);
			System.out.println("进来" +bcy.getBusinessCompanyRegion());
//			System.out.println(businessCompanyPayTaxes==null);
//			System.out.println(businessCompanyPayTaxes=="null");
//			System.out.println(businessCompanyPayTaxes.equals("null"));
		    bcy.setBusinessCompany(businessCompany==null||businessCompany.equals("null")?null:Integer.valueOf(businessCompany));
			bcy.setBusinessCompanyPayTaxes(businessCompanyPayTaxes==null||businessCompanyPayTaxes.equals("null")?null:Integer.valueOf(businessCompanyPayTaxes));
			bcy.setBusinessCompanyAccount(businessCompanyAccount==null||businessCompanyAccount.equals("null")?null:Integer.valueOf(businessCompanyAccount));
			bcy.setBusinessCompanyIndustry(businessCompanyIndustry==null||businessCompanyIndustry.equals("null")?null:businessCompanyIndustry);
			System.out.println("浏览量为"+currentPage+businessCompanyRegion);
			response.setCharacterEncoding("utf-8");
			JSONArray jsonArray = JSONArray.fromObject(wxbcs.selectBusinessCompany(currentPage,bcy));
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray);

			
		}
      //		查询单个公司的信息 
		@RequestMapping("/selectOneCompany")
		public void  selectOneBusinessCompany(int businessCompanyId,HttpServletResponse response)throws IOException{
			
	  
	     	System.out.println("浏览量为"+businessCompanyId);
			response.setCharacterEncoding("utf-8");
			JSONArray jsonArray = JSONArray.fromObject(wxbcs.selectOneBusinessCompany(businessCompanyId));
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray);

			
		}
	 
}
