package com.woman.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.woman.pojo.company;
import com.woman.pojo.shareholder;
import com.woman.tool.DateTime;
import com.woman.tool.UpdataName;
import com.woman.tool.UploadHelper;
import com.woman.tool.WordUtils;
import com.women.service.CompanyService;

import net.coobird.thumbnailator.Thumbnails;
import net.sf.json.JSONArray;

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
		        String myappPath = mypath.replace("\\"+UpdataName.projectName,"\\RegistCompanyIMG");
		        //如果目录不存在则创建
		        File uploadDir = new File(myappPath);
		        if (!uploadDir.exists()) {
		        boolean  t =   uploadDir.mkdir();
		        System.out.println("OK"+t+myappPath); }   
		        String myimgpath = myappPath+UPLOAD_DIRECTORY+"\\";
		        File fip = new File(myimgpath);
                //文件没有创建	        
		        if (!fip.exists()) {
		        	  boolean  t =   fip.mkdir();
		        	  System.out.println("OK"+t+myimgpath);} 
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
		        imgpath = myimgpath+newFileName;
		        System.out.println(imgpath);
		        //将内存中的数据写入磁盘  
		        file.transferTo(newFile);    
		        //将新图片名称写到itemsCustom中  		        
		        //注意路径http://www.chuanshoucs.com/  http://shensu.free.ngrok.cc/
		        String  mypath1 =  mypath.replace("\\"+UpdataName.projectName,"");		        		        
		        imgpath=imgpath.replace(mypath1,UpdataName.urlName+"/");
		        System.out.println(">>>>"+imgpath);	
		        imgpath = imgpath.replaceAll("\\\\","/");
		        }      
				PrintWriter pw = response.getWriter();
				pw.print(imgpath);			
		 }
		       //word的文档	 
	    @RequestMapping(value = "exportMillCertificate", method = RequestMethod.GET)   
	    public void exportMillCertificate(int companyId,HttpServletRequest request,  
	                      HttpServletResponse response) throws Exception {  
	    	  //list文档下载	    	
        	company  c=   companyService.comList(companyId);
	          //获得数据，系统相关，就不展示了  
	        Map<String, Object> map = new HashMap<String, Object>();  
	        map.put("company",c);  
	        map.put("shareList",c.getShareholder());
	        map.put("companyName",c.getCompanyname());
             //map.put("businessscope",c.getregisteredcapital());  
             //map.put("remarkname",c.getRegisteredcapital());
	        WordUtils.exportMillCertificateWord(request,response,map);  
	    }  
	    
	        //图片下载	  
		@RequestMapping(value = "downloadImg", method = RequestMethod.GET)  
	    public void download( int companyId,HttpServletRequest request, HttpServletResponse response) throws IOException{
	    	company  c=   companyService.comList(companyId);          
                String downloadFilename = c.getCompanyname()+"公司股东身份证打包"+DateTime.getDay()+".zip";//文件的名称
                downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");//转换中文否则可能会产生乱码
                response.setContentType("application/octet-stream");// 指明response的返回对象是文件流 
                response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);// 设置在下载框默认显示的文件名
                ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());                 
                List<shareholder> sharList = c.getShareholder();
                int number= 0;
                for (shareholder shareholder : sharList) {                	
                	UploadHelper.downImg(shareholder.getName()+"的正面身份证"+(number++),shareholder.getIdimgZ(),zos);
                	UploadHelper.downImg(shareholder.getName()+"的反面身份证"+(number++),shareholder.getIdimgF(),zos);
                }            
                zos.flush();     
                zos.close();
               
        
    }
            
             //服务器上传图片 压缩图片	返回地址
		@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)  
	    public void uploadImg(@RequestParam("file")MultipartFile file,String imgSize, String imgQuality,HttpServletRequest request, HttpServletResponse response) throws IOException{
            System.out.println("imgstr"+imgSize+imgQuality);
			Map<String,String> map = uploadFile(file, request,imgSize,imgQuality);  			
			System.out.println(map.toString());
			JSONArray jsonObject = JSONArray.fromObject(map);
			PrintWriter pw = response.getWriter();
			pw.print(jsonObject);  
        
    }

		private Map uploadFile(MultipartFile file, HttpServletRequest request,String imgSize, String imgQuality) throws IOException {
			/*图片上传*/
			String imgpath = "";
			String zipiMG="";
			Map<String,String> map = new HashMap(); 
			String mypath = request.getSession().getServletContext().getRealPath("/");

			System.out.println(mypath);
			//路径转换 用域名转换
			String mypath1 = mypath.replace("\\"+UpdataName.projectName,"");	
		  
			  //原始名称
	        String myappPath = mypath.replace("\\"+UpdataName.projectName,"\\ServerImg");
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
	
	        map.put("imgpathSize", Long.toString(file.getSize()/1024)+"kb");
	        //将新图片名称写到itemsCustom中  
	        
           //将文件压缩	 开始      
	         zipiMG = myimgpath+UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));	 
	        Thumbnails.of(imgpath) 
	        .scale(Float.parseFloat(imgSize+"f")) 
	        .outputQuality(Float.parseFloat(imgQuality+"f")) 
	        .toFile(zipiMG);
	
	        map.put("zipImgSize", Long.toString(getFileSize(zipiMG))+"kb");
	        zipiMG=zipiMG.replace(mypath1,UpdataName.urlName+"/");
	        zipiMG = zipiMG.replaceAll("\\\\","/");
	        System.out.println("zipiMG>>>>"+zipiMG);	
	        map.put("zipiMG",zipiMG);
	  
	       //将文件压缩	结束 
	        
	        //注意路径http://www.chuanshoucs.com/  http://shensu.free.ngrok.cc/	       	        		        
	        imgpath=imgpath.replace(mypath1,UpdataName.urlName+"/");	        
	        imgpath = imgpath.replaceAll("\\\\","/");
	        System.out.println(">>>>"+imgpath);	
	        map.put("imgpath",imgpath);
	      
	        }
			return  map;
		}
         
           //读取文件的大小
	    public static long getFileSize(String filename) {
	        File file = new File(filename);
	        if (!file.exists() || !file.isFile()) {
	            System.out.println("文件不存在");
	            return -1;
	        }
	        return file.length()/1024;
	    }

}
