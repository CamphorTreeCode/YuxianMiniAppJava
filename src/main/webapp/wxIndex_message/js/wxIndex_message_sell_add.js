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
			
			/*公司类型特殊事件 start*/
			$(".companyTypeList input").on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
			    console.info($(this).parent().css("backgroundImage")+"点解")
				$(this).parent().css("backgroundImage",$(this).parent().css("backgroundImage"))
		    });
			
			$(".companyTypeList input").on('ifUnchecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定 
				var url=$(this).parent().css("backgroundImage")
				var index=url.lastIndexOf(".")
				var head=url.substr(0,index-1)
				var foot=url.substring(index)
				var newurl=head+foot
	            $(this).parent().css("backgroundImage",newurl)
				console.info($(this).parent().css("backgroundImage")+"失去焦点")
		    });
			
			
			/*公司类型特殊事件 end*/
	})