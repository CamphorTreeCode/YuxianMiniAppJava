// JavaScript Document
$(function(){
      parent.swiper();
	  $(".del").click(function(){
		 var img=$("[name=img]").val()
		  $("#preview").attr("src",img)
		  $("#preview").hide();
		  $(".addIcon").show();
		  $(this).hide();
		  })
	 $(".del1").click(function(){
		 var img=$("[name=img1]").val()
		  $("#preview1").attr("src",img)
		  $("#preview1").hide();
		  $(".addIcon1").show();
		  $(this).hide();
		  })
	  $(".del2").click(function(){
		  var img=$("[name=img2]").val()
		  $("#preview2").attr("src",img)
		  $("#preview2").hide();
		  $(".addIcon2").show();
		  $(this).hide();
		  })	    
	  $(".line .ylIcon").click(function(){
		   var a=$("#preview").attr("src")
		   if(a==""){
			   alert("请选择图片")
			   }
			else{
				$(".content").hide();
			   $(".yl img").attr("src",a);
			   $(".yl").show();
		   }
		  
		  })
		$(".line .ylIcon1").click(function(){
		   var a=$("#preview1").attr("src")
		   if(a==""){
			   alert("请选择图片")
			   }
			else{
				$(".content").hide();
			   $(".yl img").attr("src",a);
			   $(".yl").show();
		   }
		  
		  })
		  $(".line .ylIcon2").click(function(){
		   var a=$("#preview2").attr("src")
		   if(a==""){
			   alert("请选择图片")
			   }
			else{
				$(".content").hide();
			   $(".yl img").attr("src",a);
			   $(".yl").show();
		   }
		  
		  })
	  $(".yl").click(function(){
		   $(".content").show();
		   $(this).hide();
		  })
		  
	   $(".submit").click(function(){
		  var a=confirm("确认修改图片1?")
		  if(a==true){
			  var id=$("[name=swiperid]").val();
			  var file=$(".file")[0].files[0];
			  var img1=$("[name=img]").val();
		      alert(file)
		      var formFile = new FormData();
                formFile.append("swiperid", id);   
                formFile.append("file", file);
                formFile.append("img1", img1);//加入文件对象
		      $.ajax({    
		          url : "../swiper/update1",    
		          type : "POST",    
		          data :formFile, 
		          contentType: false,//必须false才会自动加上正确的Content-Type  
	              processData:false,//必须false才会避开jQuery对 formdata 的默认处理.XMLHttpRequest会对 formdata 进行正确的处理.
		          success : function(data) {    
		        	  var aa=eval(data)
		        	  $("#preview").attr("src",aa[0].url)
		          },
		          error : function(data) {    
		                 
		          }    
		     });   
		  }
		  
	  })
	  $(".submit1").click(function(){
		  var a=confirm("确认修改图片2?")
		  if(a==true){
			  var id=$("[name=swiperid1]").val();
			  var file=$(".file1")[0].files[0];
			  var img1=$("[name=img1]").val();
			  console.log(file)
		      alert(file)
		      var formFile = new FormData();
                formFile.append("swiperid", id);   
                formFile.append("file", file); //加入文件对象
                formFile.append("img1", img1);
		      $.ajax({    
		          url : "../swiper/update1",    
		          type : "POST",    
		          data :formFile, 
		          contentType: false,//必须false才会自动加上正确的Content-Type  
	              processData:false,//必须false才会避开jQuery对 formdata 的默认处理.XMLHttpRequest会对 formdata 进行正确的处理.
		          success : function(data) {    
		        	  var aa=eval(data)
		        	  $("#preview1").attr("src",aa[0].url) 
		          },
		          error : function(data) {    
		                 
		          }    
		     });   
		  }
		  
	  })
	  $(".submit2").click(function(){
		  var a=confirm("确认修改图片3?")
		  if(a==true){
			  var id=$("[name=swiperid2]").val();
			  var file=$(".file2")[0].files[0];
			  var img1=$("[name=img2]").val();
			  console.log(file)
		      alert(file)
		      var formFile = new FormData();
                formFile.append("swiperid", id);   
                formFile.append("file", file); //加入文件对象
                formFile.append("img1", img1); //加入文件对象
		      $.ajax({    
		          url : "../swiper/update1",    
		          type : "POST",    
		          data :formFile, 
		          contentType: false,//必须false才会自动加上正确的Content-Type  
	              processData:false,//必须false才会避开jQuery对 formdata 的默认处理.XMLHttpRequest会对 formdata 进行正确的处理.
		          success : function(data) {    
		        	  var aa=eval(data)
		        	  $("#preview2").attr("src",aa[0].url)
		          },
		          error : function(data) {    
		                 
		          }    
		     });   
		  }
		  
	  })
	  
	})