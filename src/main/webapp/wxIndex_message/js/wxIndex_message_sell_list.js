// JavaScript Document

$(function(){
	/*鼠标移到到图片栏位显示是否查看大图 离开隐藏查看大图 start*/
	$(".slideshow").hover(
	          function(){
				 $(this).find(".preview").fadeIn(300);	 
				  },
			  function(){
				 
				   $(this).find(".preview").fadeOut(300);
				  }
			  )
	
	
	/*鼠标移到到图片栏位显示是否查看大图  离开隐藏查看大图 end*/
	   
      /*点击预览大图出现预览界面 start*/
	 
	 /*设置轮播vessel margin-left所需的数据为全局变量 start*/
	 
	  var long=0;
	  
	  var num=0;
	  
	 /*设置轮播vessel margin-left所需的数据为全局变量 end*/
	  
	  $(".slideshow .preview").click(function(){
		  
		       var a=$(this).next().html()
		       
			   num=$(this).next().find("img").length
			   
			   /*给vessel样式初始化 start*/
			   
			   $(".window .vessel").attr("style","margin-left:"+(-(num-1)*528)+"px")
			   
			   long=(-(num-1)*528);
			   
			   /*给vessel样式初始化 end*/
			   
		       $(".window .vessel").html(a)
		  
			   $(".content").hide(300);
			   
			   $(".perviewOutBorder").show(300);
		 
		  
		  })
	  /*点击预览大图出现预览界面 end*/
	  
	  /*点击预览界面关闭按钮关闭预览界面 start*/
	  $(".bigImgPreviewClose").click(function(){
		       $(".window .vessel").html("")
			   
		       $(".content").show(300);
			   
			   $(".perviewOutBorder").hide(300);
		  
		  
		  })
	  /*点击预览界面关闭按钮关闭预览界面 end*/  
	  
	  /*图片轮播上一页 start*/
	     /*小遗憾动态改变vessel 宽度失败*/
	 
	  
	  
	  
	  $(".bigImgFront").click(function(){
	
		  
		  if(long>=-(num-2)*528){
			  
		  long-=528;
		  }
		  $(".window .vessel").attr("style","margin-left:"+long+"px")
		  
		  })
	  /*图片轮播上一页 end*/  
	  
	  /*图片轮播下一页 start*/
	  $(".bigImgRear").click(function(){
		  if(long<0){
		   long+=528;
		  }
		  $(".window .vessel").attr("style","margin-left:"+long+"px")
		  
		  })
	  /*图片轮播下一页 end*/
	
	})