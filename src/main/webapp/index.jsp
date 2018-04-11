<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申肃后台</title>

<script type="text/javascript">

</script>
<style>
* {
	margin: 0;
	padding: 0;
}

.lf {
	float: left
}

.cl {
	clear: both;
}

.ri {
	float: right;
}

.box {
	display: flex;
	display: -webkit-flex; /*webkit*/
	-moz-justify-content: flex-start;
	-webkit-justify-content: flex-start;
	justify-content: flex-start;
	-webkit-box-align: center;
	-moz-align-items: center;
	-webkit-align-items: center;
	align-items: center;
}

.boxCenter {
	display: flex;
	display: -webkit-flex; /*webkit*/
	-moz-justify-content: center;
	-webkit-justify-content: center;
	justify-content: centert;
	-webkit-box-align: center;
	-moz-align-items: center;
	-webkit-align-items: center;
	align-items: center;
}

.body {
	height: 100%;
	width: 100%;
	background-image: url('img/background.png');
	background-repeat: no-repeat;
	background-size: 100% 100%;
	-moz-background-size: 100% 100%;
}

.lineBule {
	height: 6%;
	background-image: url('img/topback.png');
	background-repeat: no-repeat;
	background-size: 100% 100%;
	-moz-background-size: 100% 100%;
}

.leftImg {
	height: 70%;
	width: 3%;
	margin-left: 10%;
}

.leftImg img {
	width: 100%;
	height: 100%;
}

.leftWord {
	color: #fff;
	font-size: 1.4rem;
	margin-left: 1%;
}

.bodyCenter {
	height: 94%;
}

.contenBody {
	height: 50%;
	width: 39%;
	margin: 0 auto;
}

.headImg {
	height: 20%;
}

.headImg img {
	border-radius: 50%;
	height: 100%;
}

.welcome {
	color: #6BC9FF;
	font-size: 1.3rem;
	height: 15%;
}

.userName {
	height: 16%;
}

.userNameContent {
	background: #DEF2FD;
	width: 62%;
	height: 80%;
	border-radius: 300px;
}

.userNameContent input {
	background: #DEF2FD;
	border: none;
	width: 73%;
	margin-left: 10%;
	height: 67%;
	font-size: 1.3rem;
	color: #9CD8FE;
	outline: none;
}

.userNameContent img {
	width: 10%;
	height: 78%;
}

.loginBut {
	height: 20%;
}

.loginBut button {
	width: 32%;
	color: #fff;
	background: #8AD5FD;
	height: 50%;
	font-size: 1.3rem;
	border-radius: 300px;
	border: none;
	outline: none;
}

input::-webkit-input-placeholder {
	color: #9CD8FE;
}
</style>
>>>>>>> branch 'master' of https://git.cloud.tencent.com/w602542704/regCompany.git
</head>
<link rel="stylesheet" href="css/index.css" type="text/css" />
<script src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
  function notice(){
		$(".position span").html("发布公告")
		$(".stateType").show(500);
		$(".wxIndex_messageType").hide(500);
		$(".wxIndex_message").removeClass("clickColor");
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
		$(".notice").addClass("clickColor");
		$(".sell").removeClass("clickColor");
		$(".buy").removeClass("clickColor");
		}
	
	 function stateTypeli1(){
	    $(".position span").html("公告查询")
	    $(".stateType li").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
		$(".sell").removeClass("clickColor");
		$(".buy").removeClass("clickColor");
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
		$(".sell").removeClass("clickColor");
		$(".buy").removeClass("clickColor");
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
	function employee(){
		$(".position span").html("员工管理")
		$(".stateType").hide(500);
		aa();
		$(".employee").addClass("clickColor");
		
		
	}
	function sell(){
	  $(".position span").html("首页信息管理>我要卖")
		$(".stateType").hide(500);
		$(".wxIndex_messageType").show(500);
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".buy").removeClass("clickColor");
		$(".wxIndex_message").removeClass("clickColor");
		$(".sell").addClass("clickColor");
		$(".employee").removeClass("clickColor");
	}
	function buy(){
	  $(".position span").html("首页信息管理>我要买")
		$(".stateType").hide(500);
		$(".wxIndex_messageType").show(500);
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".wxIndex_messageType").show(500);
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".sell").removeClass("clickColor");
		$(".wxIndex_message").removeClass("clickColor");
		$(".buy").addClass("clickColor");
		$(".employee").removeClass("clickColor");
		
	}
	function aa(){
		$(".stateType").hide(500);
		$(".wxIndex_messageType").hide();
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
		$(".wxIndex_message").removeClass("clickColor");
		$(".sell").removeClass("clickColor");
		$(".buy").removeClass("clickColor");
		$(".employee").removeClass("clickColor");
	}
	
	
	
	 $(function(){
	    
	    $(".wxIndex_message").click(function(){
	    
	         $(".stateType").hide(500);
		    $(".stateType li").removeClass("clickColor");
			$(".wxIndex").removeClass("clickColor");
			$(".notice").removeClass("clickColor");
			$(".regist").removeClass("clickColor");
			$(".option").removeClass("clickColor");
			$(".swiper").removeClass("clickColor");
			$(".wxIndex_message").removeClass("clickColor");
			$(".sell").removeClass("clickColor");
			$(".buy").removeClass("clickColor");
	        $(".wxIndex_message").addClass("clickColor");
		    $(".wxIndex_messageType").show(500);
		    $(".employee").removeClass("clickColor");
		 
		 
		 })
		 $(".sell").click(function(){
		    
		     $(".position span").html("首页信息管理>我要卖")
		$(".stateType").hide(500);
		$(".wxIndex_messageType").show(500);
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".buy").removeClass("clickColor");
		$(".wxIndex_message").removeClass("clickColor");
		$(".sell").removeClass("clickColor");
		$(".employee").removeClass("clickColor");
		 
		 
		 
		 })
		 $(".buy").click(function(){
		 $(".position span").html("首页信息管理>我要买")
		$(".stateType").hide(500);
		$(".wxIndex_messageType").show(500);
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(".option").removeClass("clickColor");
		$(".swiper").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".sell").removeClass("clickColor");
		$(".wxIndex_message").removeClass("clickColor");
		$(".employee").removeClass("clickColor");
		$(".buy").addClass("clickColor");
		 
		 })
	 
	 
	 })
	 
    
</script>
<body>
   <div class="body">
       <div  class="top"><img src="img/微信图片_20180313180704.png" />小程序后台</div>
       <div class="content">
       <div class="left">
            <c:if test="${sessionScope.user.adminState==0 }">
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

           

                <a href="../employee/list" target="if"><li class="employee"><div class="icon"></div>员工管理</li></a>
            </c:if>
            <div class="wxIndex_messageList">
               <li class="wxIndex_message"><div class="icon"></div><div>首页信息管理</div><div class="icon" id="xhicon"></div></li>
               <ul class="wxIndex_messageType" style="display:none">
                   <a href="../wxIndex_message/list?businessCompany=0" target="if"><li class="sell">我要卖</li></a>
                   <a href="../wxIndex_message/list?businessCompany=1" target="if"><li class="buy">我要买</li></a>
               </ul>
               
            </div>
          </div>
          <div class="position">当前位置：<span>微信小程序</span></div>
       <div class="right">
         
         <c:if test="${sessionScope.user.adminState==null }">
         <iframe src="../notice/wxIndex?businessCompany=0" name="if"></iframe>
         </c:if>
       
         <c:if test="${sessionScope.user.adminState==0 }">
         <iframe src="../notice/wxIndex?businessCompany=0" name="if"></iframe>
         </c:if>
         
         <c:if test="${sessionScope.user.adminState==1 }">
         <iframe src="../wxIndex_message/list?businessCompany=0" name="if"></iframe>
         </c:if>
         
       </div>
     
       
   </div>
   </div>
</body>
</html>
