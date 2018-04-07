package com.woman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.woman.pojo.BusinessCompany;
import com.woman.tool.Page;
import com.women.service.BusinessCompanyService;


@Controller
@RequestMapping("wxIndex_message")
public class BusinessCompanyController {
   @Autowired
   BusinessCompanyService businessCompanyService;
   

    @RequestMapping("list")
	public String list(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,
			Model model,@RequestParam(value="businessCompany",defaultValue="1",required=false)int businessCompany){
		
	    Page<BusinessCompany> a= businessCompanyService.getByBusinessCompany(currentPage, businessCompany);
	    System.out.println(a.getLists().size()+"**************************************************************************");
		model.addAttribute("businessCompanyPage",businessCompanyService.getByBusinessCompany(currentPage, businessCompany));
		model.addAttribute("businessCompany",businessCompany);
		return "wxIndex_message/wxIndex_message_list";
	}
    
    @RequestMapping(value="add",method=RequestMethod.GET)
    public String insert(){
    	
    	return "aa";
    }
    
    @RequestMapping(value="add",method=RequestMethod.POST)
    public String insertsave(){
    	
    	return "aa";
    }

}
