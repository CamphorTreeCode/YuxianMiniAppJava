// JavaScript Document
$(function(){
	 
	
	 /*图片上传 start*/
	 $('.view').on('change','.viewimg .addIcon input',function(){
		 
		  $(this).parent(".addIcon").prev(".preview").show();
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }
		$(this).parent(".addIcon").next(".del").show();
		$(this).parent(".addIcon").hide();
        //获取文件
        var file = $(this)[0].files[0];
        var imageType = /^image\//;
        //是否是图片
        if (!imageType.test(file.type)) {
            alert("请选择图片！");
            return;
        }
		var img=$(this).parent(".addIcon").prev()[0];
		
		/*动态添加一个上传图片div start*/
		var signadd=true/*是否添加上传图片按钮标记*/
        //读取完成
        reader.onload = function(e) {
         
		if($(".view .viewimg").length>8){
			
			 signadd=false;
			
			}   
			$(".view .viewimg").each(function(i){
				   
				 if($(this).find(".addIcon").find("input").val()==""){	   
					   signadd=false;   
					 }
				
				
				})
            //图片路径设置为读取的图片
            img.src = e.target.result;
			if(signadd){
				var div="<div class='viewimg'>"
					 div+="<img class='preview' />"
					 div+=" <div class='addIcon'><input type='file' name='file' class='file' /></div>"
					 div+=" <div class='del' style='display:none'></div>"
					 div+="</div>"
				$(".view").append(div)
			}
		   /*动态添加一个上传图片div end*/	
        };
        reader.readAsDataURL(file);
		   
        
    })
	
	 /*图片上传 end*/
	
	$('.view').on('click','.viewimg .del',function(){
		  /*删除上传的图片时 如果有多余的上传图片div 删除自身div start*/
		  var signdel=false;
		  $(".view .viewimg").each(function(i){			  
				 if($(this).find(".addIcon").find("input").val()==""){
					   signdel=true;					   
					 }		
				})
		   if(signdel){
               $(this).parent(".viewimg").remove();
		   }
		   /*删除上传的图片时 如果有多余的上传图片div 删除自身div start*/
		   
		  /*点击取消上传的图片重新上传 start*/ 		
		  $(this).prev().find("input").val("")
		  $(this).prev().prev().attr("src","")
		  $(this).prev().prev().hide();
		  $(this).prev(".addIcon").show();
		  $(this).hide();
		  /*点击取消上传的图片重新上传 end*/ 	
		  
		  /*点击单选按钮将元素改为蓝色 start*/
		  
		  /*点击单选按钮将元素改为蓝色 end*/
        
    })
	        /*icheck回掉函数 start*/

            $('input').on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定 
				  $(this).parent().parent().parent().css("color","#1897DA")
		    });
			 
			$('input').on('ifUnchecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定 
				  $(this).parent().parent().parent().css("color","#666")
		    });
            /*icheck回掉函数 end*/	
			/*表单验证 start*/
			/*设置一些表单的最大长度 start*/
			$("[name=businessCompanyName]").attr({maxlength:45})
	        $("[name=businessCompanyCapital]").attr({maxlength:8})
	        $("[name=businessCompanyNumber]").attr({maxlength:45})
	        $("[name=businessCompanyCreatDate]").attr({maxlength:30})
	        var bus=$("[name=businessCompany]").val()
	        var adminState=$("[name=adminState]").val();
	        /*设置一些表单的最大长度  end*/
           $("#submit").click(function(){
		    	var r=true;
		    	//验证上传图片最少一张
		    	if($("[name=file1]").length>0){
		    		
		    	}
		    	if($("[name=file1]").length==0){
			    	$("[name=file]").each(function(){
			    		if($(this).val()!=""){
			    			return false;
			    		}
			    		else{
			    			r=false;   			
			    		}
			    		
			    		
			    	})
		    	}
		    	if(r==false){
		    		alert("至少上传一张图片")
		    		return false;
		    	}
		    	//验证内容不为空
		    	if($("[name=businessCompanyContent]").val()==""){
		    		r=false
		    		alert($("[name=businessCompanyContent]").attr('placeholder'))
	    			return false;
		    	}
		    	if(bus==0){
		    	//判断公司名称最大长度不能超过45
		        
		    	if($("[name=businessCompanyName]").val()==""){
		    		r=false;
		    		alert("请输入公司名称")
		    		return false;
		    	}
		        //判读注册资本长度不能大于10
		        if($("[name=businessCompanyCapital]").val()==""){
		    		r=false;
		    		alert("请输入注册资本")
		    		return false;
		    	}
		        //判读注册资本输入为数字
		        if($("[name=businessCompanyCapital]").val()!=""){
		        	var re = /^[0-9]+.?[0-9]*$/;
		        	var nubmer = $("[name=businessCompanyCapital]").val()
		          　　           if (!re.test(nubmer)) {
		          　　          	r=false;
		               　　　　alert("注册资本请输入合格数字");
		               　　　　return false;
		           　　       }
		        }
		        //判断公司注册号
		        
		        if($("[name=businessCompanyNumber]").val()==""){
		    		r=false;
		    		alert("请输入社会信用代码")
		    		return false;
		    	}
		        //判断纳税类型是否为空
		        var sign=false
		        $("[name=businessCompanyPayTaxes]").each(function(){
		        	if($(this).prop("checked")){
    		    		sign=true;	
    		    	}
		        })
		        if(sign==false){
    		    	r=false;
    		    	alert($("[name=businessCompanyPayTaxes]").attr("alertvalue"))
    		    	return false;
    		    }
		        
		        //判断公司注册时间是否为空
		        if($("[name=businessCompanyCreatDate]").val()==""){
		    		r=false;
		    		alert("请输入公司注册时间")
		    		return false;
		    	}
		        re=/\d{4}\-\d{2}\-\d{2}/g
		        if(!re.test($("[name=businessCompanyCreatDate]").val())){
		        	r=false;
		        	alert("请按提示格式输入日期")
		        	return false;
		        }
		        //判断经营范围是否为空
		        if($("[name=businessCompanyRange]").val()==""){
		    		r=false
		    		alert($("[name=businessCompanyRange]").attr('placeholder'))
	    			return false;
		    	}
		        //判断公司行业是否为空
		        var sign1=false;
		        $("[name=businessCompanyIndustry]").each(function(){
		        	if($(this).prop("checked")){
    		    		sign1=true;	
    		    	}
		        })
		        if(sign1==false){
    		    	r=false;
    		    	alert($("[name=businessCompanyIndustry]").attr("alertvalue"))
    		    	return false;
    		    }
		        
		        //判断银行账户是否为空
		        var sign2=false
		        $("[name=businessCompanyAccount]").each(function(){
		        	if($(this).prop("checked")){
    		    		sign2=true;	
    		    	}
		        })
		        if(sign2==false){
    		    	r=false;
    		    	alert($("[name=businessCompanyAccount]").attr("alertvalue"))
    		    	return false;
    		    }
		        
		        //判断税务信息
		        
		        var sign3=false
		        $("[name=businessCompanyTax]").each(function(){
		        	if($(this).prop("checked")){
    		    		sign3=true;	
    		    	}
		        })
		        if(sign3==false){
    		    	r=false;
    		    	alert($("[name=businessCompanyTax]").attr("alertvalue"))
    		    	return false;
    		    }
		        
		        
		        //判断是否置顶
		        if(adminState==0){
			        var sign4=false
			        $("[name=businessCompanyTop]").each(function(){
			        	if($(this).prop("checked")){
	    		    		sign4=true;	
	    		    	}
			        })
			        if(sign4==false){
	    		    	r=false;
	    		    	alert($("[name=businessCompanyTop]").attr("alertvalue"))
	    		    	return false;
	    		    }
		        }
		    	/*
		    	var list=$(".companyDetails input")
		    	list.each(function(i){
		    		if(i==6){
		    			if($("[name=businessCompanyRange]").val()==""){
				    		r=false
				    		alert($("[name=businessCompanyRange]").attr('placeholder'))
			    			return false;
				    	}
		    			
		    		}
		    		
		    		
		    	
		    		if($(this).attr("type")=="text"){
		    			if($(this).val()==""){
			    			r=false
			    			alert($(this).attr('placeholder'))
			    			return false;
			    		}
		    		}
		    		
		    		
		    		if($(this).attr("type")=="radio"){
		    		    var name=$(this).attr("name")
		    		    var sign=false
		    		    var listbyname= $("[name="+name+"]")
		    		    listbyname.each(function(i,e){
		    		    	if($(e).prop("checked")){
		    		    		sign=true;
		    		    		
		    		    	}
		    		    	
		    		    })
		    		    if(sign==false){
		    		    	r=false;
		    		    	alert($(listbyname[0]).attr("alertvalue"))
		    		    	return false;
		    		    }
		    		}
		    		
		    	})*/
		    	}    
		    	
		     return r;
		    	
		    })
			
			
			
			/*表单验证 end*/
			
			
			
	})