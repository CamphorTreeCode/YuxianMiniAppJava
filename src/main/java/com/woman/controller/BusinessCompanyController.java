package com.woman.controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.woman.pojo.Admin;
import com.woman.pojo.BusinessCompany;
import com.woman.pojo.CompanyImg;
import com.woman.tool.DateTime;
import com.woman.tool.Token;
import com.woman.tool.UploadHelper;
import com.women.service.BusinessCompanyService;
import com.women.service.CompanyImgService;
import com.women.service.LoginService;


@Controller
@RequestMapping("wxIndex_message")
public class BusinessCompanyController {
   @Autowired
   BusinessCompanyService businessCompanyService;
   @Autowired
   CompanyImgService companyImgService;
   @Autowired
   LoginService loginService;
    /*根据买 或 卖状态实现相应分页*/
    @RequestMapping("list")
	public String list(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,
			Model model,@RequestParam(value="businessCompany",defaultValue="1",required=false)int businessCompany,HttpServletRequest request){
    	Admin a=(Admin) request.getSession().getAttribute("user");
    	int AdminState=a.getAdminState();
    	int AdminId=a.getAdminId();
    	System.out.println(businessCompanyService.getByBusinessCompany(currentPage, businessCompany,AdminState,AdminId).getLists().size());
    	model.addAttribute("businessCompanyPage",businessCompanyService.getByBusinessCompany(currentPage, businessCompany,AdminState,AdminId));
		model.addAttribute("businessCompany",businessCompany);
		return "wxIndex_message/wxIndex_message_list";
	}
    /*跳转添加页面带  买或卖状态*/
    @Token(save=true)
    @RequestMapping(value="add",method=RequestMethod.GET)
    public String insert(int businessCompany,HttpServletRequest request){
    	request.setAttribute("b",businessCompany);
    	return "wxIndex_message/wxIndex_message_add";
    }
    /*保存添加表单到数据库*/
    @Token(remove=true)
    @RequestMapping(value="add",method=RequestMethod.POST)
    public String insertsave(BusinessCompany b,@RequestParam("file") MultipartFile file[],HttpServletRequest request,String address[])throws IOException{
    	String ars="";
    	if(b.getBusinessCompanyTop()==null){
    		b.setBusinessCompanyTop(0);
    	}
    	if(b.getBusinessCompanyBrowse()==null){
    		b.setBusinessCompanyBrowse(0);
    	}
    	for (int i = 0; i < address.length; i++) {
			if(i<address.length-1){
    		  ars+=address[i]+"-";
			}
			else{
			  ars+=address[i];
			}
		}
    	int c=b.getBusinessCompany();
    	b.setBusinessCompanyCreatTime(new DateTime().getDate());
    	b.setBusinessCompanyRegion(ars);
    	businessCompanyService.insertbusinessCompany(b);
    	int a=b.getBusinessCompanyId();
    	for (MultipartFile f : file) {
    		String img=UploadHelper.upload(f, request);
    		if(img!=""){
				CompanyImg cimg=new CompanyImg();
				cimg.setBusinessCompanyId(a);
				cimg.setCompanyUrl(img);
				cimg.setCompanyCreatTime(new DateTime().getDate());
				companyImgService.insertCompanyImgMapper(cimg);
    		}
		}
    	return "redirect:list?businessCompany="+c+"";
    }
    //跳转更新页面
    @Token(save=true)
    @RequestMapping(value="update",method=RequestMethod.GET)
    public String update(int id,HttpServletRequest request){
    	BusinessCompany buc=businessCompanyService.findById(id);
    	List<CompanyImg> imgList=companyImgService.getByBid(id);
    	int b=buc.getBusinessCompany();
    	request.setAttribute("buc", buc);
    	request.setAttribute("b", b);
    	request.setAttribute("imgList", imgList);
    	return  "wxIndex_message/wxIndex_message_update";
    }
    //更新保存
    @Token(remove=true)
    @RequestMapping(value="update",method=RequestMethod.POST)
    public String updatesave(BusinessCompany b,@RequestParam("file") MultipartFile file[],HttpServletRequest request,String address[],String file1[])throws IOException{
    	String ars="";
    	for (int i = 0; i < address.length; i++) {
			if(i<address.length-1){
    		  ars+=address[i]+"-";
			}
			else{
			  ars+=address[i];
			}
		}
    	
    	int a=b.getBusinessCompanyId();
    	b.setBusinessCompanyRegion(ars);
    	System.out.println(b.getAdminId());
    	businessCompanyService.updateBusinessCompany(b);
    	companyImgService.deleteByBid(a);
    	int c=b.getBusinessCompany();
    	for (int i = 0; i < file1.length; i++) {
    		String img=UploadHelper.upload(file[i], request);
    		if(img!=""){
				CompanyImg cimg=new CompanyImg();
				cimg.setCompanyUrl(img);
			    cimg.setBusinessCompanyId(a);
			    cimg.setCompanyCreatTime(new DateTime().getDate());
				companyImgService.insertCompanyImgMapper(cimg);
    		}else{
    			if(!file1[i].equals("")){
	    			CompanyImg cimg=new CompanyImg();
					cimg.setCompanyUrl(file1[i]);
					cimg.setBusinessCompanyId(a);
					cimg.setCompanyCreatTime(new DateTime().getDate());
					companyImgService.insertCompanyImgMapper(cimg);
    			}
    		}
		}
    	return "redirect:list?businessCompany="+c+"";
    }
    //删除一条信息
    @RequestMapping("del")
    public String del(int id,int businessCompany){
    	companyImgService.deleteByBid(id);
    	businessCompanyService.deletebusinessCompany(id);
    	return "redirect:list?businessCompany="+businessCompany+"";
    }
    //修改置顶状态
    @RequestMapping("updataTop")
    public String updataTop(int id,int businessCompany,int businessCompanyTop){
    	
    	BusinessCompany buc=businessCompanyService.findById(id);
    	
    	buc.setBusinessCompanyTop(businessCompanyTop);
    	businessCompanyService.updateBusinessCompany(buc);
    	return "redirect:list?businessCompany="+businessCompany+"";
    }
    //查看一条记录的详情
    @RequestMapping("look")
    public String look(int id,HttpServletRequest request){
    	System.out.println("进入查看方法*****************************************************************************************");
    	BusinessCompany buc=businessCompanyService.findById(id);
    	List<CompanyImg> imgList=companyImgService.getByBid(id);
    	int b=buc.getBusinessCompany();
    	request.setAttribute("buc", buc);
    	request.setAttribute("b", b);
    	request.setAttribute("imgList", imgList);
    	return  "wxIndex_message/wxIndex_message_look";
    	
    }

}
