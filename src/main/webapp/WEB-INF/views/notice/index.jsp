<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>玉先后台</title>
</head>
<link rel="stylesheet" href="css/index.css" type="text/css" />
<script src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
  function notice(){
		$(".position span").html("发布公告")
		$(".stateType").show(500);
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
		$(".notice").addClass("clickColor");
		}
	
	 function stateTypeli1(){
	    $(".position span").html("公告查询")
	    $(".stateType li").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
	    $(".stateType li:eq(1)").addClass("clickColor");
		
		}
		 function stateTypeli2(){
	    $(".position span").html("公告查询")
	    $(".stateType li").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
	    $(".stateType li:eq(0)").addClass("clickColor");
		
		}
	function wxIndex(){
		$(".position span").html("小程序首页")
		$(".stateType").hide(500);
		aa();
		$(".wxIndex").addClass("clickColor");
		}
	function regist(){
		 $(".position span").html("工商注册信息")
		 $(".stateType").hide(500);
		aa();
		$(".regist").addClass("clickColor");
		}
	function option(){
		$(".position span").html("选项管理")
		$(".stateType").hide(500);
		aa();
		$(".option").addClass("clickColor");
		
		
	}
	function swiper(){
		$(".position span").html("轮播图管理")
		$(".stateType").hide(500);
		aa();
		$(".swiper").addClass("clickColor");
		
		
	}
	function sell(){
	  $(".position span").html("首页信息管理>我要卖")
		$(".stateType").hide(500);
		aa();
		$(".sell").addClass("clickColor");
	}
	function buy(){
	  $(".position span").html("首页信息管理>我要买")
		$(".stateType").hide(500);
		aa();
		$(".buy").addClass("clickColor");
	}
	function aa(){
		$(".stateType").hide(500);
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
		$(".sell").removeClass("clickColor");
		$(".buy").removeClass("clickColor");
	}
	
	
	
	 $(function(){
	    
	    $(".wxIndex_message").click(function(){
		 $(".wxIndex_messageType").toggle(500);
		 
		 
		 })
	 
	 
	 })
	 
    
</script>
<body>
   <div class="body">
       <div  class="top"><img src="img/微信图片_20180313180704.png" />小程序后台</div>
       <div class="content">
       <div class="left">
          
            <a href="../notice/wxIndex" target="if"><li class="wxIndex"><div class="icon"></div>小程序首页</li></a>
            <div class="../noticeList">
               <a href="../notice/addnotice" target="if"><li class="notice"><div class="icon"></div><div>公告发布</div><div class="icon" id="xhicon"></div></li></a>
               <ul class="stateType" style="display:none">
                   <a href="../notice/getbystate?state=2" target="if"><li >已发布</li></a>
                   <a href="../notice/getbystate" target="if"><li >草稿箱</li></a>
               </ul>
               
          </div>
            <a href="../company/companyPage" target="if"><li class="regist"><div class="icon"></div>工商注册信息</li></a>
            <a href="../text/textindex" target="if"><li class="option"><div class="icon"></div>选项管理</li></a>
            <a href="../swiper/swiper" target="if"><li class="swiper"><div class="icon"></div>轮播图管理</li></a>
            <div class="wxIndex_messageList">
               <li class="wxIndex_message"><div class="icon"></div><div>首页信息管理</div><div class="icon" id="xhicon"></div></li>
               <ul class="wxIndex_messageType" style="display:none">
                   <a href="wxIndex_message_sell_list.html" target="if"><li class="sell">我要卖</li></a>
                   <a href="issueList.html" target="if"><li class="buy">我要买</li></a>
               </ul>
               
            </div>
          </div>
          <div class="position">当前位置：<span>微信小程序</span></div>
       <div class="right">
         <iframe src="../notice/wxIndex" name="if"></iframe>
       </div>
     
       
   </div>
   </div>
</body>
</html>
