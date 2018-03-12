package com.woman.tool;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UploadHelper {
	
	public static String upload(MultipartFile file,HttpServletRequest request){
		Calendar a=Calendar.getInstance();
	    int y=a.get(Calendar.YEAR);//得到年
	    int m=a.get(Calendar.MONTH)+1;//由于月份是从0开始的所以加1
	    int d=a.get(Calendar.DATE);
	    String path = request.getSession().getServletContext().getRealPath("upload/"+y+"-"+m+"-"+d+"");  
        String fileName = file.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        String newName=System.currentTimeMillis()+Math.random()*9999+suffix;
        File dir = new File(path,newName);          
        if(!dir.exists()){  
            dir.mkdirs();  
        } 
        //MultipartFile自带的解析方法  
        try {
			file.transferTo(dir);
		} 
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        System.out.println(path+"\\"+newName);
        return path+"\\"+newName;  
	}
	

}
