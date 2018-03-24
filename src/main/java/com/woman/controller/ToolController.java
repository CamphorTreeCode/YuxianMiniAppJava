package com.woman.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.woman.pojo.company;
import com.woman.tool.DateTime;
import com.woman.tool.WordUtils;
import com.women.service.CompanyService;

@Controller
@RequestMapping("/tool")
public class ToolController {
	// 上传文件存储目录
	 @Autowired
	 private CompanyService companyService;
    private   String UPLOAD_DIRECTORY = DateTime.getDay();  
		//查询栏目列
		 @RequestMapping("/addImg")  
		public void selectColumn(@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException{
			 /*图片上传*/
				String imgpath = "";
				String mypath = request.getSession().getServletContext().getRealPath("/");
  
				System.out.println(mypath);
				  //原始名称
		        String myappPath = mypath.replace("\\Maven_Project","\\RegistCompanyIMG");
		        // 如果目录不存在则创建
		        File uploadDir = new File(myappPath);
		        if (!uploadDir.exists()) {
		          boolean  t =   uploadDir.mkdir();
		            System.out.println("OK"+t+myappPath);
		        }   
		        String myimgpath = myappPath+UPLOAD_DIRECTORY+"\\";
		        File fip = new File(myimgpath);
               //	文件没有创建	        
		        if (!fip.exists()) {
		        	  boolean  t =   fip.mkdir();
		        	    System.out.println("OK"+t+myimgpath);
		        	} 
                //上传图片的名称		        
		        System.out.println(myimgpath);
		        String originalFilename = file.getOriginalFilename(); 
		        System.out.println(">>>>>>>>>>>"+originalFilename);
		 
		        //上传图片  
		        if(file!=null && originalFilename!=null && originalFilename.length()>0){          
		        //存储图片的物理路径  
		   
		        //新的图片名称  
		       String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));  
		        //新图片  
		        File newFile = new File(myimgpath+newFileName);  
		        imgpath=myimgpath+newFileName;
		        System.out.println(imgpath);
		        //将内存中的数据写入磁盘  
		        file.transferTo(newFile);    
		        //将新图片名称写到itemsCustom中  
		        
		        //注意路径http://www.chuanshoucs.com/  http://shensu.free.ngrok.cc/
		        String mypath1 = mypath.replace("\\Maven_Project","");		        		        
		        imgpath=imgpath.replace(mypath1,"https://www.chuanshoucs.com/");
		        System.out.println(">>>>"+imgpath);	
		        imgpath = imgpath.replaceAll("\\\\","/");
		        }      
				PrintWriter pw = response.getWriter();
				pw.print(imgpath);
			
		 }
		 //word的文档
	 
	    @RequestMapping(value = "exportMillCertificate", method = RequestMethod.GET)  
	    @ResponseBody  
	    public void exportMillCertificate(int companyId,HttpServletRequest request,  
	                      HttpServletResponse response) throws Exception {  
	    	 //list文档下载
	    	
    	company c =   companyService.comList(companyId);
	        //获得数据，系统相关，就不展示了  
	        Map<String, Object> map = new HashMap<String, Object>();  
	        map.put("companyname",c.getCompanyname());  
	        map.put("remarkname",c.getRemarkname());  
	        map.put("enterprisetype",c.getEnterprisetype());  
	        map.put("registeredcapital",c.getRegisteredcapital());
//	        map.put("businessscope",c.getregisteredcapital());  
//	        map.put("remarkname",c.getRegisteredcapital());
	        WordUtils.exportMillCertificateWord(request,response,map);  
	    }  
}
