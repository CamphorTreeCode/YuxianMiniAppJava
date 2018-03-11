package com.woman.tool;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
	
	 public String upload(MultipartFile file,HttpServletRequest request) throws IOException{  
	        String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename();
	        String suffix=fileName.substring(fileName.lastIndexOf("."));
	        String newName=System.currentTimeMillis()+Math.random()*9999+suffix;
	        File dir = new File(path,fileName);          
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        //MultipartFile自带的解析方法  
	        file.transferTo(dir);  
	        return "ok!";  
	    } 

}
