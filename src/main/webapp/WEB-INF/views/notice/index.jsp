<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<link rel="stylesheet" href="css/index.css" type="text/css" />
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/index.js"></script>
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
            <a href="issueList.html" target="if"><li class="regist"><div class="icon"></div>工商注册信息</li></a>
          </div>
          <div class="position">当前位置：<span>公告发布</span></div>
       <div class="right">
         <iframe src="issueList.html" name="if"></iframe>
       </div>
     
       
   </div>
   </div>
</body>
</html>
